package com.poliglotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poliglotes.model.Aula;
import com.poliglotes.services.AulaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aulas")
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @PostMapping("/cadastrar")
    public Aula cadastrarAula(@RequestBody Aula aula) {
        return aulaService.cadastrarAula(aula);
    }

    @GetMapping("/{id}")
    public Optional<Aula> getAulaById(@PathVariable String id) {
        return aulaService.findAulaById(id);
    }

    @GetMapping("/all")
    public List<Aula> getAllAulas() {
        return aulaService.findAllAulas();
    }

    @PutMapping("/atualizar")
    public Aula atualizarAula(@RequestBody Aula aula) {
        return aulaService.atualizarAula(aula);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarAula(@PathVariable String id) {
        aulaService.deletarAula(id);
    }
}

