package com.poliglotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poliglotes.model.FalanteNativo;
import com.poliglotes.services.FalanteNativoService;

import java.util.Optional;

@RestController
@RequestMapping("/falantes-nativos")
public class FalanteNativoController {
    @Autowired
    private FalanteNativoService falanteNativoService;

    @PostMapping("/cadastrar")
    public FalanteNativo cadastrarFalanteNativo(@RequestBody FalanteNativo falanteNativo) {
        return falanteNativoService.cadastrarFalanteNativo(falanteNativo);
    }

    @GetMapping("/{id}")
    public Optional<FalanteNativo> getFalanteNativoById(@PathVariable String id) {
        return falanteNativoService.findFalanteNativoById(id);
    }

    @PutMapping("/atualizar")
    public FalanteNativo atualizarPerfil(@RequestBody FalanteNativo falanteNativo) {
        return falanteNativoService.atualizarPerfil(falanteNativo);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarFalanteNativo(@PathVariable String id) {
        falanteNativoService.deletarFalanteNativo(id);
    }
}

