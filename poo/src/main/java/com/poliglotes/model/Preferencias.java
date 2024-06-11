package com.poliglotes.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Preferencias {
    @Id
    private String id;

    @DBRef
    private List<Idioma> idiomasInteresse;
    private String nivelDificuldade;
    private List<String> topicosInteresse;

	public void atualizarPreferencias() {

	}
	// Getters and Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Idioma> getIdiomasInteresse() {
		return idiomasInteresse;
	}

	public void setIdiomasInteresse(List<Idioma> idiomasInteresse) {
		this.idiomasInteresse = idiomasInteresse;
	}

	public String getNivelDificuldade() {
		return nivelDificuldade;
	}

	public void setNivelDificuldade(String nivelDificuldade) {
		this.nivelDificuldade = nivelDificuldade;
	}

	public List<String> getTopicosInteresse() {
		return topicosInteresse;
	}

	public void setTopicosInteresse(List<String> topicosInteresse) {
		this.topicosInteresse = topicosInteresse;
	}
	

}
