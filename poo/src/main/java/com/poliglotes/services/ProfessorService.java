package com.poliglotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poliglotes.model.Professor;
import com.poliglotes.repositorios.ProfessorRepository;

import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor cadastrarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Optional<Professor> findProfessorById(String id) {
        return professorRepository.findById(id);
    }

    public Professor atualizarPerfil(Professor professor) {
        Optional<Professor> existingProfessor = professorRepository.findById(professor.getId());
        if (existingProfessor.isPresent()) {
            return professorRepository.save(professor);
        } else {
            throw new RuntimeException("Professor não encontrado com id " + professor.getId());
        }
    }

    public void deletarProfessor(String id) {
        professorRepository.deleteById(id);
    }
}
