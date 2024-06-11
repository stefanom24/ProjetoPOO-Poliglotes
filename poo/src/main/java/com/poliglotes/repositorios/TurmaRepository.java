package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Turma;

public interface TurmaRepository extends MongoRepository<Turma, String> {}