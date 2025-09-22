package com.example.proj_soft_1.controller;

import com.example.proj_soft_1.model.Filme;
import com.example.proj_soft_1.service.FilmeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FilmeController.class)
public class FilmeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FilmeService service;

    @Test
    void deveListarFilmes() throws Exception {
        Filme filme = new Filme();
        filme.setTitulo("Matrix");
        when(service.listAll()).thenReturn(Arrays.asList(filme));

        mockMvc.perform(get("/filmes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Matrix"));
    }

    @Test
    void deveCriarFilme() throws Exception {
        Filme filme = new Filme();
        filme.setTitulo("Inception");

        when(service.save(Mockito.any(Filme.class))).thenReturn(filme);

        mockMvc.perform(post("/filmes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(filme)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Inception"));
    }
}
