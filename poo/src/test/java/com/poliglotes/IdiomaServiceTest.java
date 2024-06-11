package com.poliglotes;

import com.poliglotes.model.Idioma;
import com.poliglotes.repositorios.IdiomaRepository;
import com.poliglotes.services.IdiomaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IdiomaServiceTest {

    @Mock
    private IdiomaRepository idiomaRepository;

    @InjectMocks
    private IdiomaService idiomaService;

    private Idioma idioma;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        idioma = new Idioma();
        idioma.setId("1");
        idioma.setNome("Português");
    }

    @Test
    void testCadastrarIdioma() {
        when(idiomaRepository.save(idioma)).thenReturn(idioma);

        Idioma createdIdioma = idiomaService.cadastrarIdioma(idioma);

        assertNotNull(createdIdioma);
        assertEquals(idioma.getId(), createdIdioma.getId());
        verify(idiomaRepository, times(1)).save(idioma);
    }

    @Test
    void testFindIdiomaById() {
        when(idiomaRepository.findById("1")).thenReturn(Optional.of(idioma));

        Optional<Idioma> foundIdioma = idiomaService.findIdiomaById("1");

        assertTrue(foundIdioma.isPresent());
        assertEquals(idioma.getId(), foundIdioma.get().getId());
        verify(idiomaRepository, times(1)).findById("1");
    }

    @Test
    void testFindAllIdiomas() {
        when(idiomaRepository.findAll()).thenReturn(Collections.singletonList(idioma));

        assertNotNull(idiomaService.findAllIdiomas());
        verify(idiomaRepository, times(1)).findAll();
    }

    @Test
    void testAtualizarIdioma() {
        when(idiomaRepository.findById("1")).thenReturn(Optional.of(idioma));
        when(idiomaRepository.save(idioma)).thenReturn(idioma);

        Idioma updatedIdioma = idiomaService.atualizarIdioma(idioma);

        assertNotNull(updatedIdioma);
        assertEquals(idioma.getId(), updatedIdioma.getId());
        verify(idiomaRepository, times(1)).findById("1");
        verify(idiomaRepository, times(1)).save(idioma);
    }

    @Test
    void testDeletarIdioma() {
        idiomaService.deletarIdioma("1");

        verify(idiomaRepository, times(1)).deleteById("1");
    }
}
