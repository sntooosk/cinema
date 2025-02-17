package com.jcstechnol.cinema.repositories;

import com.jcstechnol.cinema.entities.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
