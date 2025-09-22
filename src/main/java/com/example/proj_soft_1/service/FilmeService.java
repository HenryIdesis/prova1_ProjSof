package com.example.proj_soft_1.service;


import com.example.proj_soft_1.model.Filme;
import com.example.proj_soft_1.repository.FilmeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public List<Filme> listAll() {
        return repository.findAll();
    }

    public Filme save(Filme filme) {
        return repository.save(filme);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
