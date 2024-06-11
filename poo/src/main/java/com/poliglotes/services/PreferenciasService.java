package com.poliglotes.services;

import com.poliglotes.model.Preferencias;
import com.poliglotes.repositorios.PreferenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PreferenciasService {

    @Autowired
    private PreferenciasRepository preferenciasRepository;

    public Preferencias cadastrarPreferencias(Preferencias preferencias) {
        return preferenciasRepository.save(preferencias);
    }

    public Optional<Preferencias> findPreferenciasById(String id) {
        return preferenciasRepository.findById(id);
    }

    public Preferencias atualizarPreferencias(Preferencias preferencias) {
        Optional<Preferencias> existingPreferencias = preferenciasRepository.findById(preferencias.getId());
        if (existingPreferencias.isPresent()) {
            return preferenciasRepository.save(preferencias);
        } else {
            throw new RuntimeException("Preferencias not found with id " + preferencias.getId());
        }
    }

    public void deletarPreferencias(String id) {
        preferenciasRepository.deleteById(id);
    }
}
