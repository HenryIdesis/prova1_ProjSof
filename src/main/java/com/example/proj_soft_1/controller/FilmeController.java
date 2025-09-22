package com.example.proj_soft_1.controller;

import com.example.proj_soft_1.model.Filme;
import com.example.proj_soft_1.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Filme> listAll() {
        return service.listAll();
    }

    @PostMapping
    public Filme create(@RequestBody Filme filme) {
        return service.save(filme);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
