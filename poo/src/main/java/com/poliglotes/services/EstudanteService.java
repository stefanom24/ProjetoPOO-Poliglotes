package com.poliglotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poliglotes.model.Estudante;
import com.poliglotes.repositorios.EstudanteRepository;

import java.util.Optional;

@Service
public class EstudanteService {
    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante cadastrarEstudante(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public Optional<Estudante> findEstudanteById(String id) {
        return estudanteRepository.findById(id);
    }

    public Estudante atualizarPerfil(Estudante estudante) {
        Optional<Estudante> existingEstudante = estudanteRepository.findById(estudante.getId());
        if (existingEstudante.isPresent()) {
            return estudanteRepository.save(estudante);
        } else {
            throw new RuntimeException("Estudante não encontrado com id " + estudante.getId());
        }
    }

    public void deletarEstudante(String id) {
        estudanteRepository.deleteById(id);
    }
}

