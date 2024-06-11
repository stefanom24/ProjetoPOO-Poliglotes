package com.poliglotes;

import com.poliglotes.model.Turma;
import com.poliglotes.repositorios.TurmaRepository;
import com.poliglotes.services.TurmaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TurmaServiceTest {

    @Mock
    private TurmaRepository turmaRepository;

    @InjectMocks
    private TurmaService turmaService;

    private Turma turma;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        turma = new Turma();
        turma.setId("1");
        turma.setListaAula(Collections.emptyList());
    }

    @Test
    void testCadastrarTurma() {
        when(turmaRepository.save(turma)).thenReturn(turma);

        Turma createdTurma = turmaService.cadastrarTurma(turma);

        assertNotNull(createdTurma);
        assertEquals(turma.getId(), createdTurma.getId());
        verify(turmaRepository, times(1)).save(turma);
    }

    @Test
    void testFindTurmaById() {
        when(turmaRepository.findById("1")).thenReturn(Optional.of(turma));

        Optional<Turma> foundTurma = turmaService.findTurmaById("1");

        assertTrue(foundTurma.isPresent());
        assertEquals(turma.getId(), foundTurma.get().getId());
        verify(turmaRepository, times(1)).findById("1");
    }

    @Test
    void testFindAllTurmas() {
        when(turmaRepository.findAll()).thenReturn(Collections.singletonList(turma));

        assertNotNull(turmaService.findAllTurmas());
        verify(turmaRepository, times(1)).findAll();
    }

    @Test
    void testAtualizarTurma() {
        when(turmaRepository.findById("1")).thenReturn(Optional.of(turma));
        when(turmaRepository.save(turma)).thenReturn(turma);

        Turma updatedTurma = turmaService.atualizarTurma(turma);

        assertNotNull(updatedTurma);
        assertEquals(turma.getId(), updatedTurma.getId());
        verify(turmaRepository, times(1)).findById("1");
        verify(turmaRepository, times(1)).save(turma);
    }

    @Test
    void testDeletarTurma() {
        turmaService.deletarTurma("1");

        verify(turmaRepository, times(1)).deleteById("1");
    }
}
