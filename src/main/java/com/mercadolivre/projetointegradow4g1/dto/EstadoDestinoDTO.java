package com.mercadolivre.projetointegradow4g1.dto;

import com.mercadolivre.projetointegradow4g1.entities.Comprador;
import com.mercadolivre.projetointegradow4g1.entities.EstadoDestino;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDestinoDTO {

    @NotNull
    @NotEmpty(message = "O nome do estado é obrigatório")
    private String nome;

    @NotNull
    private Double distanciaOrigem;
    private Comprador comprador;

    public static EstadoDestino converte(EstadoDestinoDTO dto){
        EstadoDestino estadoDestino = EstadoDestino.builder()
                .nome(dto.getNome())
                .distanciaOrigem(dto.getDistanciaOrigem())
                .comprador(dto.getComprador())
                .build();
        return estadoDestino;
    }

    public static EstadoDestinoDTO converte(EstadoDestino estadoDestino){
        return EstadoDestinoDTO.builder()
                .nome(estadoDestino.getNome())
                .distanciaOrigem(estadoDestino.getDistanciaOrigem())
                .comprador(estadoDestino.getComprador())
                .build();
    }

    public static List<EstadoDestinoDTO> converte(List<EstadoDestino> estadoDestinos){
        return estadoDestinos.stream().map(a -> converte(a)).collect(Collectors.toList());
    }


}
