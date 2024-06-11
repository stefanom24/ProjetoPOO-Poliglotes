package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Aula;

public interface AulaRepository extends MongoRepository<Aula, String> {}
