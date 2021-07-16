package com.br.web.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public @Data class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch =  FetchType.EAGER)
	private List<Funcionalidades> funcionalidades;

	
	
	public Perfil() {
		super();
	}



	public Perfil(String nome, StatusEnum status, List<Funcionalidades> funcionalidades) {
		super();
		this.nome = nome;
		this.status = status;
		this.funcionalidades = funcionalidades;
	}
	
	public Perfil(String nome, StatusEnum status) {
		super();
		this.nome = nome;
		this.status = status;
	}
}
