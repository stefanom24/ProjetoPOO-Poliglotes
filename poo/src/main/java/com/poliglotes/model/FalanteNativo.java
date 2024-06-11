package com.poliglotes.model;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class FalanteNativo extends Pessoa {
    @DBRef
    private List<Idioma> idiomasDisponiveis;

	public void conversar() {

	}

	public void agendarSessao() {

	}

    public List<Idioma> getIdiomasDisponiveis() {
        return idiomasDisponiveis;
    }

    public void setIdiomasDisponiveis(List<Idioma> idiomasDisponiveis) {
        this.idiomasDisponiveis = idiomasDisponiveis;
    }

	 // Getters and Setters
	 

}
