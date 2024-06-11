package com.poliglotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poliglotes.model.FalanteNativo;
import com.poliglotes.repositorios.FalanteNativoRepository;

import java.util.Optional;

@Service
public class FalanteNativoService {
    @Autowired
    private FalanteNativoRepository falanteNativoRepository;

    public FalanteNativo cadastrarFalanteNativo(FalanteNativo falanteNativo) {
        return falanteNativoRepository.save(falanteNativo);
    }

    public Optional<FalanteNativo> findFalanteNativoById(String id) {
        return falanteNativoRepository.findById(id);
    }

    public FalanteNativo atualizarPerfil(FalanteNativo falanteNativo) {
        Optional<FalanteNativo> existingFalanteNativo = falanteNativoRepository.findById(falanteNativo.getId());
        if (existingFalanteNativo.isPresent()) {
            return falanteNativoRepository.save(falanteNativo);
        } else {
            throw new RuntimeException("Falante Nativo não encontrado com id " + falanteNativo.getId());
        }
    }

    public void deletarFalanteNativo(String id) {
        falanteNativoRepository.deleteById(id);
    }
}
