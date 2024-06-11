package com.poliglotes;

import com.poliglotes.model.Professor;
import com.poliglotes.repositorios.ProfessorRepository;
import com.poliglotes.services.ProfessorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProfessorServiceTest {

    @Mock
    private ProfessorRepository professorRepository;

    @InjectMocks
    private ProfessorService professorService;

    private Professor professor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        professor = new Professor();
        professor.setId("1");
        professor.setEmail("professor@example.com");
        professor.setSenha("password123");
        professor.setNome("Professor Example");
        professor.setMatricula("123456");
    }

    @Test
    void testCadastrarProfessor() {
        when(professorRepository.save(professor)).thenReturn(professor);

        Professor createdProfessor = professorService.cadastrarProfessor(professor);

        assertNotNull(createdProfessor);
        assertEquals(professor.getId(), createdProfessor.getId());
        verify(professorRepository, times(1)).save(professor);
    }

    @Test
    void testFindProfessorById() {
        when(professorRepository.findById("1")).thenReturn(Optional.of(professor));

        Optional<Professor> foundProfessor = professorService.findProfessorById("1");

        assertTrue(foundProfessor.isPresent());
        assertEquals(professor.getId(), foundProfessor.get().getId());
        verify(professorRepository, times(1)).findById("1");
    }

    @Test
    void testAtualizarProfessor() {
        when(professorRepository.findById("1")).thenReturn(Optional.of(professor));
        when(professorRepository.save(professor)).thenReturn(professor);

        Professor updatedProfessor = professorService.atualizarPerfil(professor);

        assertNotNull(updatedProfessor);
        assertEquals(professor.getId(), updatedProfessor.getId());
        verify(professorRepository, times(1)).findById("1");
        verify(professorRepository, times(1)).save(professor);
    }

    @Test
    void testDeletarProfessor() {
        professorService.deletarProfessor("1");

        verify(professorRepository, times(1)).deleteById("1");
    }
}
