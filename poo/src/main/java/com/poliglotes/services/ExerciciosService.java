package com.poliglotes.services;

import com.poliglotes.model.Exercicios;
import com.poliglotes.repositorios.ExerciciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciciosService {

    @Autowired
    private ExerciciosRepository exerciciosRepository;

    public Exercicios cadastrarExercicio(Exercicios exercicio) {
        return exerciciosRepository.save(exercicio);
    }

    public Optional<Exercicios> findExercicioById(String id) {
        return exerciciosRepository.findById(id);
    }

    public List<Exercicios> findAllExercicios() {
        return exerciciosRepository.findAll();
    }

    public Exercicios atualizarExercicio(Exercicios exercicio) {
        Optional<Exercicios> existingExercicio = exerciciosRepository.findById(exercicio.getId());
        if (existingExercicio.isPresent()) {
            return exerciciosRepository.save(exercicio);
        } else {
            throw new RuntimeException("Exercicios not found with id " + exercicio.getId());
        }
    }

    public void deletarExercicio(String id) {
        exerciciosRepository.deleteById(id);
    }
}
