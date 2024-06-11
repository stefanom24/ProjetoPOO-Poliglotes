package com.poliglotes;


import com.poliglotes.model.Disciplina;
import com.poliglotes.repositorios.DisciplinaRepository;
import com.poliglotes.services.DisciplinaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DisciplinaServiceTest {

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @InjectMocks
    private DisciplinaService disciplinaService;

    private Disciplina disciplina;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        disciplina = new Disciplina();
        disciplina.setId("1");
        disciplina.setEmenta("Ementa de Teste");
        disciplina.setCriteriosAvaliacao("Criterios de Avaliação de Teste");
    }

    @Test
    void testCadastrarDisciplina() {
        when(disciplinaRepository.save(disciplina)).thenReturn(disciplina);

        Disciplina createdDisciplina = disciplinaService.cadastrarDisciplina(disciplina);

        assertNotNull(createdDisciplina);
        assertEquals(disciplina.getId(), createdDisciplina.getId());
        verify(disciplinaRepository, times(1)).save(disciplina);
    }

    @Test
    void testFindDisciplinaById() {
        when(disciplinaRepository.findById("1")).thenReturn(Optional.of(disciplina));

        Optional<Disciplina> foundDisciplina = disciplinaService.findDisciplinaById("1");

        assertTrue(foundDisciplina.isPresent());
        assertEquals(disciplina.getId(), foundDisciplina.get().getId());
        verify(disciplinaRepository, times(1)).findById("1");
    }

    @Test
    void testAtualizarDisciplina() {
        when(disciplinaRepository.findById("1")).thenReturn(Optional.of(disciplina));
        when(disciplinaRepository.save(disciplina)).thenReturn(disciplina);

        Disciplina updatedDisciplina = disciplinaService.atualizarDisciplina(disciplina);

        assertNotNull(updatedDisciplina);
        assertEquals(disciplina.getId(), updatedDisciplina.getId());
        verify(disciplinaRepository, times(1)).findById("1");
        verify(disciplinaRepository, times(1)).save(disciplina);
    }

    @Test
    void testDeletarDisciplina() {
        disciplinaService.deletarDisciplina("1");

        verify(disciplinaRepository, times(1)).deleteById("1");
    }
}
