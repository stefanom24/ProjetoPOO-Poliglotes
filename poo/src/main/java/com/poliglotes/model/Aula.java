package com.poliglotes.model;

import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Aula {
    @Id
    private String id;

    @DBRef
    private List<Exercicios> exerciciosCompletados;
    private int pontuacao;

 

	public void atualizarProgresso() {

	}

	public void visualizarHistorico() {

	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public List<Exercicios> getExerciciosCompletados() {
		return exerciciosCompletados;
	}

	public void setExerciciosCompletados(List<Exercicios> exerciciosCompletados) {
		this.exerciciosCompletados = exerciciosCompletados;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	// Getters and Setters
	

}
