package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {}
