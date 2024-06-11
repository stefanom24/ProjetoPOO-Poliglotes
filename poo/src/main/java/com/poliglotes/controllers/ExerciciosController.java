package com.poliglotes.controllers;

import com.poliglotes.model.Exercicios;
import com.poliglotes.services.ExerciciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercicios")
public class ExerciciosController {

    @Autowired
    private ExerciciosService exerciciosService;

    @PostMapping("/cadastrar")
    public Exercicios cadastrarExercicio(@RequestBody Exercicios exercicio) {
        return exerciciosService.cadastrarExercicio(exercicio);
    }

    @GetMapping("/{id}")
    public Optional<Exercicios> getExercicioById(@PathVariable String id) {
        return exerciciosService.findExercicioById(id);
    }

    @GetMapping("/all")
    public List<Exercicios> getAllExercicios() {
        return exerciciosService.findAllExercicios();
    }

    @PutMapping("/atualizar")
    public Exercicios atualizarExercicio(@RequestBody Exercicios exercicio) {
        return exerciciosService.atualizarExercicio(exercicio);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarExercicio(@PathVariable String id) {
        exerciciosService.deletarExercicio(id);
    }
}
