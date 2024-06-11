package com.poliglotes;

import com.poliglotes.model.Aula;
import com.poliglotes.repositorios.AulaRepository;
import com.poliglotes.services.AulaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AulaServiceTest {

    @Mock
    private AulaRepository aulaRepository;

    @InjectMocks
    private AulaService aulaService;

    private Aula aula;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        aula = new Aula();
        aula.setId("1");
        aula.setExerciciosCompletados(Collections.emptyList());
        aula.setPontuacao(0);
    }

    @Test
    void testCadastrarAula() {
        when(aulaRepository.save(aula)).thenReturn(aula);

        Aula createdAula = aulaService.cadastrarAula(aula);

        assertNotNull(createdAula);
        assertEquals(aula.getId(), createdAula.getId());
        verify(aulaRepository, times(1)).save(aula);
    }

    @Test
    void testFindAulaById() {
        when(aulaRepository.findById("1")).thenReturn(Optional.of(aula));

        Optional<Aula> foundAula = aulaService.findAulaById("1");

        assertTrue(foundAula.isPresent());
        assertEquals(aula.getId(), foundAula.get().getId());
        verify(aulaRepository, times(1)).findById("1");
    }

    @Test
    void testFindAllAulas() {
        when(aulaRepository.findAll()).thenReturn(Collections.singletonList(aula));

        assertNotNull(aulaService.findAllAulas());
        verify(aulaRepository, times(1)).findAll();
    }

    @Test
    void testAtualizarAula() {
        when(aulaRepository.findById("1")).thenReturn(Optional.of(aula));
        when(aulaRepository.save(aula)).thenReturn(aula);

        Aula updatedAula = aulaService.atualizarAula(aula);

        assertNotNull(updatedAula);
        assertEquals(aula.getId(), updatedAula.getId());
        verify(aulaRepository, times(1)).findById("1");
        verify(aulaRepository, times(1)).save(aula);
    }

    @Test
    void testDeletarAula() {
        aulaService.deletarAula("1");

        verify(aulaRepository, times(1)).deleteById("1");
    }
}
