package com.poliglotes;

import com.poliglotes.model.Estudante;
import com.poliglotes.repositorios.EstudanteRepository;
import com.poliglotes.services.EstudanteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EstudanteServiceTest {

    @Mock
    private EstudanteRepository estudanteRepository;

    @InjectMocks
    private EstudanteService estudanteService;

    private Estudante estudante;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        estudante = new Estudante();
        estudante.setId("1");
        estudante.setEmail("john.doe@example.com");
        estudante.setSenha("password123");
        estudante.setNome("John Doe");
    }

    @Test
    void testCadastrarEstudante() {
        when(estudanteRepository.save(estudante)).thenReturn(estudante);

        Estudante createdEstudante = estudanteService.cadastrarEstudante(estudante);

        assertNotNull(createdEstudante);
        assertEquals(estudante.getId(), createdEstudante.getId());
        verify(estudanteRepository, times(1)).save(estudante);
    }

    @Test
    void testFindEstudanteById() {
        when(estudanteRepository.findById("1")).thenReturn(Optional.of(estudante));

        Optional<Estudante> foundEstudante = estudanteService.findEstudanteById("1");

        assertTrue(foundEstudante.isPresent());
        assertEquals(estudante.getId(), foundEstudante.get().getId());
        verify(estudanteRepository, times(1)).findById("1");
    }

    @Test
    void testAtualizarEstudante() {
        when(estudanteRepository.findById("1")).thenReturn(Optional.of(estudante));
        when(estudanteRepository.save(estudante)).thenReturn(estudante);

        Estudante updatedEstudante = estudanteService.atualizarPerfil(estudante);

        assertNotNull(updatedEstudante);
        assertEquals(estudante.getId(), updatedEstudante.getId());
        verify(estudanteRepository, times(1)).findById("1");
        verify(estudanteRepository, times(1)).save(estudante);
    }

    @Test
    void testDeletarEstudante() {
        estudanteService.deletarEstudante("1");

        verify(estudanteRepository, times(1)).deleteById("1");
    }
}
