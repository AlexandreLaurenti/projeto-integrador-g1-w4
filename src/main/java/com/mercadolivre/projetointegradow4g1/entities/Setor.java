package com.mercadolivre.projetointegradow4g1.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mercadolivre.projetointegradow4g1.entities.enums.CondicaoConservacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_setor")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Setor {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotNull
    @NotEmpty
	private String nome;
    
    @NotNull
	private Double capacidadeTotal;
    
    @NotNull
	private Double capacidadeAtual;
    
    @NotNull
	private CondicaoConservacao tipo;

	@ManyToOne
	private Armazem armazem;
		
	@OneToMany(mappedBy = "setor")
	@JsonIgnore
	private Set<RegistroDeEstoque> registroDeEstoques;

}
