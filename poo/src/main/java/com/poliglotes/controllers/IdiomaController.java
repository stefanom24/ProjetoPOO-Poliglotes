package com.poliglotes.controllers;

import com.poliglotes.model.Idioma;
import com.poliglotes.services.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @PostMapping("/cadastrar")
    public Idioma cadastrarIdioma(@RequestBody Idioma idioma) {
        return idiomaService.cadastrarIdioma(idioma);
    }

    @GetMapping("/{id}")
    public Optional<Idioma> getIdiomaById(@PathVariable String id) {
        return idiomaService.findIdiomaById(id);
    }

    @GetMapping("/all")
    public List<Idioma> getAllIdiomas() {
        return idiomaService.findAllIdiomas();
    }

    @PutMapping("/atualizar")
    public Idioma atualizarIdioma(@RequestBody Idioma idioma) {
        return idiomaService.atualizarIdioma(idioma);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarIdioma(@PathVariable String id) {
        idiomaService.deletarIdioma(id);
    }
}
