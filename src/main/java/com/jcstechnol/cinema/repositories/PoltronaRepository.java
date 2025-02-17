package com.jcstechnol.cinema.repositories;

import com.jcstechnol.cinema.entities.Poltrona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoltronaRepository extends JpaRepository<Poltrona, Long> {
    List<Poltrona> findBySessaoId(Long sessaoId);
}