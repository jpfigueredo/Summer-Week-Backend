package com.digitalhouse.ApiFilmes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

//1
// Definindo modelo
// @Getter @Setter é do lombok

@Entity
@Getter
@Setter
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String titulo;
	private String descricao;
	private String urlImg;
	
	

}
