package com.poliglotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poliglotes.model.Professor;
import com.poliglotes.services.ProfessorService;

import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping("/cadastrar")
    public Professor cadastrarProfessor(@RequestBody Professor professor) {
        return professorService.cadastrarProfessor(professor);
    }

    @GetMapping("/{id}")
    public Optional<Professor> getProfessorById(@PathVariable String id) {
        return professorService.findProfessorById(id);
    }

    @PutMapping("/atualizar")
    public Professor atualizarPerfil(@RequestBody Professor professor) {
        return professorService.atualizarPerfil(professor);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProfessor(@PathVariable String id) {
        professorService.deletarProfessor(id);
    }
}
