package com.jcstechnol.cinema.repositories;

import com.jcstechnol.cinema.entities.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    @Query("SELECT s FROM Sessao s WHERE s.filme.id = :filmeId")
    List<Sessao> findByFilmeId(@Param("filmeId") Long filmeId);
}
