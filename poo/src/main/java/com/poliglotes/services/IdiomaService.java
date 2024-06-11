package com.poliglotes.services;

import com.poliglotes.model.Idioma;
import com.poliglotes.repositorios.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdiomaService {

    @Autowired
    private IdiomaRepository idiomaRepository;

    public Idioma cadastrarIdioma(Idioma idioma) {
        return idiomaRepository.save(idioma);
    }

    public Optional<Idioma> findIdiomaById(String id) {
        return idiomaRepository.findById(id);
    }

    public List<Idioma> findAllIdiomas() {
        return idiomaRepository.findAll();
    }

    public Idioma atualizarIdioma(Idioma idioma) {
        Optional<Idioma> existingIdioma = idiomaRepository.findById(idioma.getId());
        if (existingIdioma.isPresent()) {
            return idiomaRepository.save(idioma);
        } else {
            throw new RuntimeException("Idioma not found with id " + idioma.getId());
        }
    }

    public void deletarIdioma(String id) {
        idiomaRepository.deleteById(id);
    }
}
