package com.poliglotes;

import com.poliglotes.model.Preferencias;
import com.poliglotes.repositorios.PreferenciasRepository;
import com.poliglotes.services.PreferenciasService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PreferenciasServiceTest {

    @Mock
    private PreferenciasRepository preferenciasRepository;

    @InjectMocks
    private PreferenciasService preferenciasService;

    private Preferencias preferencias;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        preferencias = new Preferencias();
        preferencias.setId("1");
        preferencias.setIdiomasInteresse(Collections.emptyList());
        preferencias.setNivelDificuldade("Intermediário");
        preferencias.setTopicosInteresse(Collections.singletonList("Gramática"));
    }

    @Test
    void testCadastrarPreferencias() {
        when(preferenciasRepository.save(preferencias)).thenReturn(preferencias);

        Preferencias createdPreferencias = preferenciasService.cadastrarPreferencias(preferencias);

        assertNotNull(createdPreferencias);
        assertEquals(preferencias.getId(), createdPreferencias.getId());
        verify(preferenciasRepository, times(1)).save(preferencias);
    }

    @Test
    void testFindPreferenciasById() {
        when(preferenciasRepository.findById("1")).thenReturn(Optional.of(preferencias));

        Optional<Preferencias> foundPreferencias = preferenciasService.findPreferenciasById("1");

        assertTrue(foundPreferencias.isPresent());
        assertEquals(preferencias.getId(), foundPreferencias.get().getId());
        verify(preferenciasRepository, times(1)).findById("1");
    }

    @Test
    void testAtualizarPreferencias() {
        when(preferenciasRepository.findById("1")).thenReturn(Optional.of(preferencias));
        when(preferenciasRepository.save(preferencias)).thenReturn(preferencias);

        Preferencias updatedPreferencias = preferenciasService.atualizarPreferencias(preferencias);

        assertNotNull(updatedPreferencias);
        assertEquals(preferencias.getId(), updatedPreferencias.getId());
        verify(preferenciasRepository, times(1)).findById("1");
        verify(preferenciasRepository, times(1)).save(preferencias);
    }

    @Test
    void testDeletarPreferencias() {
        preferenciasService.deletarPreferencias("1");

        verify(preferenciasRepository, times(1)).deleteById("1");
    }
}
