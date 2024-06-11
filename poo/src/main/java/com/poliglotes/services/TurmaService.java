package com.poliglotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poliglotes.model.Turma;
import com.poliglotes.repositorios.TurmaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public Turma cadastrarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Optional<Turma> findTurmaById(String string) {
        return turmaRepository.findById(string);
    }

    public List<Turma> findAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma atualizarTurma(Turma turma) {
        Optional<Turma> existingTurma = turmaRepository.findById(turma.getId());
        if (existingTurma.isPresent()) {
            return turmaRepository.save(turma);
        } else {
            throw new RuntimeException("Turma não encontrada com id " + turma.getId());
        }
    }

    public void deletarTurma(String string) {
        turmaRepository.deleteById(string);
    }
}
