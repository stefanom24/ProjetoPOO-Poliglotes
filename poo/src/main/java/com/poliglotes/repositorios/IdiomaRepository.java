package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Idioma;

public interface IdiomaRepository extends MongoRepository<Idioma, String> {}
