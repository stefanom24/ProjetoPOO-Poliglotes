package com.poliglotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poliglotes.model.Disciplina;
import com.poliglotes.services.DisciplinaService;

import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping("/cadastrar")
    public Disciplina cadastrarDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaService.cadastrarDisciplina(disciplina);
    }

    @GetMapping("/{id}")
    public Optional<Disciplina> getDisciplinaById(@PathVariable String id) {
        return disciplinaService.findDisciplinaById(id);
    }

    @PutMapping("/atualizar")
    public Disciplina atualizarDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaService.atualizarDisciplina(disciplina);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarDisciplina(@PathVariable String id) {
        disciplinaService.deletarDisciplina(id);
    }
}

