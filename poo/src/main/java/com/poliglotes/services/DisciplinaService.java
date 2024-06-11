package com.poliglotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poliglotes.model.Disciplina;
import com.poliglotes.repositorios.DisciplinaRepository;

import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina cadastrarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Optional<Disciplina> findDisciplinaById(String id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina atualizarDisciplina(Disciplina disciplina) {
        Optional<Disciplina> existingDisciplina = disciplinaRepository.findById(disciplina.getId());
        if (existingDisciplina.isPresent()) {
            return disciplinaRepository.save(disciplina);
        } else {
            throw new RuntimeException("Disciplina não encontrada com id " + disciplina.getId());
        }
    }

    public void deletarDisciplina(String id) {
        disciplinaRepository.deleteById(id);
    }
}
