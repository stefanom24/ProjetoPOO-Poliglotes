package com.poliglotes.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estudante extends Pessoa {
    @DBRef
    private Aula progresso;

	public void cadastrar() {

	}

	public void fazerLogin() {

	}

	public void editarPerfil() {

	}

    public Aula getProgresso() {
        return progresso;
    }

    public void setProgresso(Aula progresso) {
        this.progresso = progresso;
    }

	// Getters and Setters
	

}
