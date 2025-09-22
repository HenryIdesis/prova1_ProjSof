package com.example.proj_soft_1.service;


import com.example.proj_soft_1.model.Filme;
import com.example.proj_soft_1.repository.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FilmeServiceTest {

    private final FilmeRepository repository = Mockito.mock(FilmeRepository.class);
    private final FilmeService service = new FilmeService(repository);

    @Test
    void deveListarTodosOsFilmes() {
        Filme filme = new Filme();
        filme.setTitulo("Matrix");

        when(repository.findAll()).thenReturn(Arrays.asList(filme));

        List<Filme> filmes = service.listAll();
        assertEquals(1, filmes.size());
        assertEquals("Matrix", filmes.get(0).getTitulo());
    }

    @Test
    void deveSalvarFilme() {
        Filme filme = new Filme();
        filme.setTitulo("Inception");

        when(repository.save(filme)).thenReturn(filme);

        Filme salvo = service.save(filme);
        assertEquals("Inception", salvo.getTitulo());
    }

    @Test
    void deveDeletarFilme() {
        service.delete(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
