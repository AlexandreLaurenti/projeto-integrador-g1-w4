package com.mercadolivre.projetointegradow4g1.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_armazem")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Armazem {

  	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@NotNull
	private String nome, descricao;

	@OneToMany(mappedBy = "armazem")
	@JsonIgnore
	private Set<Setor> setores;

	@OneToMany(mappedBy = "armazem")
	@JsonIgnore
	private Set<Representante> representantes;
}