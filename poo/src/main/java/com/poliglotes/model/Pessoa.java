package com.poliglotes.model;


import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pessoa {
    @Id
    private String id;
    private String email;
    private String senha;
    private String nome;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getters and Setters
    
}
