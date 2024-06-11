package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Preferencias;

public interface PreferenciasRepository extends MongoRepository<Preferencias, String> {}