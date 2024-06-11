package com.poliglotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poliglotes.model.Turma;
import com.poliglotes.services.TurmaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping("/cadastrar")
    public Turma cadastrarTurma(@RequestBody Turma turma) {
        return turmaService.cadastrarTurma(turma);
    }

    @GetMapping("/{id}")
    public Optional<Turma> getTurmaById(@PathVariable String id) {
        return turmaService.findTurmaById(id);
    }

    @GetMapping("/all")
    public List<Turma> getAllTurmas() {
        return turmaService.findAllTurmas();
    }

    @PutMapping("/atualizar")
    public Turma atualizarTurma(@RequestBody Turma turma) {
        return turmaService.atualizarTurma(turma);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTurma(@PathVariable String id) {
        turmaService.deletarTurma(id);
    }
}
