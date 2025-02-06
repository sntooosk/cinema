package com.jcstechnol.cinema.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "filmes")
@Getter
@Setter
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(length = 2000)
    private String sinopse;
    private String classificacao;
    private String diretor;
    private String genero;
    private Integer duracao;
    private String thriller;

    @Lob
    private byte[] capa;
}