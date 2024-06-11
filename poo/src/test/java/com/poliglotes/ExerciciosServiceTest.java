package com.poliglotes;

import com.poliglotes.model.Exercicios;
import com.poliglotes.repositorios.ExerciciosRepository;
import com.poliglotes.services.ExerciciosService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExerciciosServiceTest {

    @Mock
    private ExerciciosRepository exerciciosRepository;

    @InjectMocks
    private ExerciciosService exerciciosService;

    private Exercicios exercicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        exercicio = new Exercicios();
        exercicio.setId("1");
        exercicio.setTipo("Tipo de Exemplo");
        exercicio.setDificuldade("Fácil");
        exercicio.setConteudo("Conteúdo de Exemplo");
    }

    @Test
    void testCadastrarExercicio() {
        when(exerciciosRepository.save(exercicio)).thenReturn(exercicio);

        Exercicios createdExercicio = exerciciosService.cadastrarExercicio(exercicio);

        assertNotNull(createdExercicio);
        assertEquals(exercicio.getId(), createdExercicio.getId());
        verify(exerciciosRepository, times(1)).save(exercicio);
    }

    @Test
    void testFindExercicioById() {
        when(exerciciosRepository.findById("1")).thenReturn(Optional.of(exercicio));

        Optional<Exercicios> foundExercicio = exerciciosService.findExercicioById("1");

        assertTrue(foundExercicio.isPresent());
        assertEquals(exercicio.getId(), foundExercicio.get().getId());
        verify(exerciciosRepository, times(1)).findById("1");
    }

    @Test
    void testFindAllExercicios() {
        when(exerciciosRepository.findAll()).thenReturn(Collections.singletonList(exercicio));

        assertNotNull(exerciciosService.findAllExercicios());
        verify(exerciciosRepository, times(1)).findAll();
    }

    @Test
    void testAtualizarExercicio() {
        when(exerciciosRepository.findById("1")).thenReturn(Optional.of(exercicio));
        when(exerciciosRepository.save(exercicio)).thenReturn(exercicio);

        Exercicios updatedExercicio = exerciciosService.atualizarExercicio(exercicio);

        assertNotNull(updatedExercicio);
        assertEquals(exercicio.getId(), updatedExercicio.getId());
        verify(exerciciosRepository, times(1)).findById("1");
        verify(exerciciosRepository, times(1)).save(exercicio);
    }

    @Test
    void testDeletarExercicio() {
        exerciciosService.deletarExercicio("1");

        verify(exerciciosRepository, times(1)).deleteById("1");
    }
}
