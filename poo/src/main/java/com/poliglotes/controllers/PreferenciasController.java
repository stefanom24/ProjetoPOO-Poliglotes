package com.poliglotes.controllers;

import com.poliglotes.model.Preferencias;
import com.poliglotes.services.PreferenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/preferencias")
public class PreferenciasController {

    @Autowired
    private PreferenciasService preferenciasService;

    @PostMapping("/cadastrar")
    public Preferencias cadastrarPreferencias(@RequestBody Preferencias preferencias) {
        return preferenciasService.cadastrarPreferencias(preferencias);
    }

    @GetMapping("/{id}")
    public Optional<Preferencias> getPreferenciasById(@PathVariable String id) {
        return preferenciasService.findPreferenciasById(id);
    }

    @PutMapping("/atualizar")
    public Preferencias atualizarPreferencias(@RequestBody Preferencias preferencias) {
        return preferenciasService.atualizarPreferencias(preferencias);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPreferencias(@PathVariable String id) {
        preferenciasService.deletarPreferencias(id);
    }
}
