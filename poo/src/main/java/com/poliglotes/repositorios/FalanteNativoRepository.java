package com.poliglotes.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.poliglotes.model.FalanteNativo;

public interface FalanteNativoRepository extends MongoRepository<FalanteNativo, String> {}
