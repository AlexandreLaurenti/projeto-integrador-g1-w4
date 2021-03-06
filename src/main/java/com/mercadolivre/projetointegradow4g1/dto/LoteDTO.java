package com.mercadolivre.projetointegradow4g1.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.mercadolivre.projetointegradow4g1.entities.Lote;
import com.mercadolivre.projetointegradow4g1.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoteDTO {
	
	@NotNull
	private Integer quantidadeInicial;
	@NotNull
	private Integer quantidadeAtual;
	@NotNull
	private Instant dataFabricacao;
  	@NotNull
	private Instant dataValidade;
	@NotNull
	private Double temperaturaAtual;
	@NotNull
	private Double temperaturaMinima;
	@NotNull
	private Produto produto;

	public static Lote converte(LoteDTO dto) {
		Lote lote = Lote.builder()
				.quantidadeInicial(dto.getQuantidadeInicial())
				.quantidadeAtual(dto.getQuantidadeAtual())
				.dataFabricacao(dto.getDataFabricacao())
				.dataValidade(dto.getDataValidade())
				.temperaturaAtual(dto.getTemperaturaAtual())
				.temperaturaMinima(dto.getTemperaturaMinima())
				.produto(dto.getProduto())
				.build();
		return lote;
	}
	
	public static LoteDTO converte(Lote lote) {
		return LoteDTO.builder()
				.quantidadeInicial(lote.getQuantidadeInicial())
				.quantidadeAtual(lote.getQuantidadeAtual())
				.dataFabricacao(lote.getDataFabricacao())
				.dataValidade(lote.getDataValidade())
				.temperaturaAtual(lote.getTemperaturaAtual())
				.temperaturaMinima(lote.getTemperaturaMinima())
				.produto(lote.getProduto())
				.build();
	}
	
	public static List<LoteDTO> converte(List<Lote> lotes){
		return lotes.stream().map(l -> converte(l)).collect(Collectors.toList());
	}
}
