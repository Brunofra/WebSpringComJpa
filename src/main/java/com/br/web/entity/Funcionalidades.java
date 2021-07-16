package com.br.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Funcionalidades {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;

	public Funcionalidades(String nome) {
		super();
		this.nome = nome;
	}

	public Funcionalidades() {
		super();
	}
	
	
}
