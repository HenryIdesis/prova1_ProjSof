package com.example.proj_soft_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proj_soft_1.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
