package com.poliglotes;

import com.poliglotes.model.FalanteNativo;
import com.poliglotes.repositorios.FalanteNativoRepository;
import com.poliglotes.services.FalanteNativoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FalanteNativoServiceTest {

    @Mock
    private FalanteNativoRepository falanteNativoRepository;

    @InjectMocks
    private FalanteNativoService falanteNativoService;

    private FalanteNativo falanteNativo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        falanteNativo = new FalanteNativo();
        falanteNativo.setId("1");
        falanteNativo.setEmail("native@example.com");
        falanteNativo.setSenha("password123");
        falanteNativo.setNome("Native Speaker");
        falanteNativo.setIdiomasDisponiveis(Collections.emptyList());
    }

    @Test
    void testCadastrarFalanteNativo() {
        when(falanteNativoRepository.save(falanteNativo)).thenReturn(falanteNativo);

        FalanteNativo createdFalanteNativo = falanteNativoService.cadastrarFalanteNativo(falanteNativo);

        assertNotNull(createdFalanteNativo);
        assertEquals(falanteNativo.getId(), createdFalanteNativo.getId());
        verify(falanteNativoRepository, times(1)).save(falanteNativo);
    }

    @Test
    void testFindFalanteNativoById() {
        when(falanteNativoRepository.findById("1")).thenReturn(Optional.of(falanteNativo));

        Optional<FalanteNativo> foundFalanteNativo = falanteNativoService.findFalanteNativoById("1");

        assertTrue(foundFalanteNativo.isPresent());
        assertEquals(falanteNativo.getId(), foundFalanteNativo.get().getId());
        verify(falanteNativoRepository, times(1)).findById("1");
    }

    @Test
    void testAtualizarFalanteNativo() {
        when(falanteNativoRepository.findById("1")).thenReturn(Optional.of(falanteNativo));
        when(falanteNativoRepository.save(falanteNativo)).thenReturn(falanteNativo);

        FalanteNativo updatedFalanteNativo = falanteNativoService.atualizarPerfil(falanteNativo);

        assertNotNull(updatedFalanteNativo);
        assertEquals(falanteNativo.getId(), updatedFalanteNativo.getId());
        verify(falanteNativoRepository, times(1)).findById("1");
        verify(falanteNativoRepository, times(1)).save(falanteNativo);
    }

    @Test
    void testDeletarFalanteNativo() {
        falanteNativoService.deletarFalanteNativo("1");

        verify(falanteNativoRepository, times(1)).deleteById("1");
    }
}
