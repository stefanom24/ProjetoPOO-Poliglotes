package com.poliglotes.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String> {}