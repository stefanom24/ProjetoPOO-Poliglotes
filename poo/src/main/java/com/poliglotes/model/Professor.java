package com.poliglotes.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Professor extends Pessoa {

	private String matricula;

	public void fazerLogin() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	

}
