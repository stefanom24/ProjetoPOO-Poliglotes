package com.poliglotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poliglotes.model.Aula;
import com.poliglotes.repositorios.AulaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    public Aula cadastrarAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Optional<Aula> findAulaById(String id) {
        return aulaRepository.findById(id);
    }

    public List<Aula> findAllAulas() {
        return aulaRepository.findAll();
    }

    public Aula atualizarAula(Aula aula) {
        Optional<Aula> existingAula = aulaRepository.findById(aula.getId());
        if (existingAula.isPresent()) {
            return aulaRepository.save(aula);
        } else {
            throw new RuntimeException("Aula não encontrada com id " + aula.getId());
        }
    }

    public void deletarAula(String id) {
        aulaRepository.deleteById(id);
    }
}
