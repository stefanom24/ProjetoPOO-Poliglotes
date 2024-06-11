package com.poliglotes.controllers;

import com.poliglotes.model.Pessoa;
import com.poliglotes.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> getPessoaById(@PathVariable String id) {
        return pessoaService.findPessoaById(id);
    }

    @PutMapping("/atualizar")
    public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.atualizarPessoa(pessoa);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPessoa(@PathVariable String id) {
        pessoaService.deletarPessoa(id);
    }
}
