package com.poliglotes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Disciplina {
    
    @Id
    private String id;
    private String ementa;
    private String criteriosAvaliacao; // Change to appropriate type if needed

    // Getters and Setters
    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getCriteriosAvaliacao() {
        return criteriosAvaliacao;
    }

    public void setCriteriosAvaliacao(String criteriosAvaliacao) {
        this.criteriosAvaliacao = criteriosAvaliacao;
    }

	public String getId() {
		return id;
	}

    public void setId(String string) {
        this.id = string;
    }
}
