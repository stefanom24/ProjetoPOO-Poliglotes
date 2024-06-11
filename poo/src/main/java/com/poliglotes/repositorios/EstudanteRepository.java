package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Estudante;

public interface EstudanteRepository extends MongoRepository<Estudante, String> {}
