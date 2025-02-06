package com.jcstechnol.cinema.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {

    private Long id;
    private String titulo;
    private String sinopse;
    private String diretor;
    private String genero;
    private Integer duracao;
    private String classificacao;
    private String thriller;
    private MultipartFile capa;
}
