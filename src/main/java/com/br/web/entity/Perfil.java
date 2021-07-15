package com.br.web.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	public Perfil( String nome, StatusEnum status) {
		super();
		this.nome = nome;
		this.status = status;
	}
	
	public Perfil() {
		super();
	}
	
	
}
