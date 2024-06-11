package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Exercicios;

public interface ExerciciosRepository extends MongoRepository<Exercicios, String> {}