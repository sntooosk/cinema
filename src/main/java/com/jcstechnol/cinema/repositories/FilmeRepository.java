package com.jcstechnol.cinema.repositories;

import com.jcstechnol.cinema.entities.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
