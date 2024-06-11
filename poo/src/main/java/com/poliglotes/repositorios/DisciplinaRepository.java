package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Disciplina;

public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {}
