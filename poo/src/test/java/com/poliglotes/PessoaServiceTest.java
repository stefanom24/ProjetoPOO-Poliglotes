package com.poliglotes;

import com.poliglotes.model.Pessoa;
import com.poliglotes.repositorios.PessoaRepository;
import com.poliglotes.services.PessoaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pessoa = new Pessoa();
        pessoa.setId("1");
        pessoa.setEmail("pessoa@example.com");
        pessoa.setSenha("password123");
        pessoa.setNome("Pessoa Exemplo");
    }

    @Test
    void testCadastrarPessoa() {
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa createdPessoa = pessoaService.cadastrarPessoa(pessoa);

        assertNotNull(createdPessoa);
        assertEquals(pessoa.getId(), createdPessoa.getId());
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void testFindPessoaById() {
        when(pessoaRepository.findById("1")).thenReturn(Optional.of(pessoa));

        Optional<Pessoa> foundPessoa = pessoaService.findPessoaById("1");

        assertTrue(foundPessoa.isPresent());
        assertEquals(pessoa.getId(), foundPessoa.get().getId());
        verify(pessoaRepository, times(1)).findById("1");
    }

    @Test
    void testAtualizarPessoa() {
        when(pessoaRepository.findById("1")).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa updatedPessoa = pessoaService.atualizarPessoa(pessoa);

        assertNotNull(updatedPessoa);
        assertEquals(pessoa.getId(), updatedPessoa.getId());
        verify(pessoaRepository, times(1)).findById("1");
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void testDeletarPessoa() {
        pessoaService.deletarPessoa("1");

        verify(pessoaRepository, times(1)).deleteById("1");
    }
}
