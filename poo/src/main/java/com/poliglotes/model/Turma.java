package com.poliglotes.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Turma {
    @Id
    private String id;

    @DBRef
    private List<Aula> listaAula;

    public String getId() {
        return id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public List<Aula> getListaAula() {
        return listaAula;
    }

    public void setListaAula(List<Aula> listaAula) {
        this.listaAula = listaAula;
    }

    // Getters and Setters
	
}
