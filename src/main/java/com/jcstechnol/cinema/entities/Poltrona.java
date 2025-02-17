package com.jcstechnol.cinema.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "poltronas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Poltrona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;

}