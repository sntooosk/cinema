package com.jcstechnol.cinema.dtos;

import org.springframework.web.multipart.MultipartFile;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getThriller() {
        return thriller;
    }

    public void setThriller(String thriller) {
        this.thriller = thriller;
    }

    public MultipartFile getCapa() {
        return capa;
    }

    public void setCapa(MultipartFile capa) {
        this.capa = capa;
    }
}
