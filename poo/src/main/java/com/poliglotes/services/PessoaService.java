package com.poliglotes.services;

import com.poliglotes.model.Pessoa;
import com.poliglotes.repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> findPessoaById(String id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa atualizarPessoa(Pessoa pessoa) {
        Optional<Pessoa> existingPessoa = pessoaRepository.findById(pessoa.getId());
        if (existingPessoa.isPresent()) {
            return pessoaRepository.save(pessoa);
        } else {
            throw new RuntimeException("Pessoa not found with id " + pessoa.getId());
        }
    }

    public void deletarPessoa(String id) {
        pessoaRepository.deleteById(id);
    }
}
