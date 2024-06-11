package com.poliglotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poliglotes.model.Estudante;
import com.poliglotes.services.EstudanteService;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteService estudanteService;

    @PostMapping("/cadastrar")
    public Estudante cadastrarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.cadastrarEstudante(estudante);
    }

    @GetMapping("/{id}")
    public Optional<Estudante> getEstudanteById(@PathVariable String id) {
        return estudanteService.findEstudanteById(id);
    }

    @PutMapping("/atualizar")
    public Estudante atualizarPerfil(@RequestBody Estudante estudante) {
        return estudanteService.atualizarPerfil(estudante);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarEstudante(@PathVariable String id) {
        estudanteService.deletarEstudante(id);
    }
}


