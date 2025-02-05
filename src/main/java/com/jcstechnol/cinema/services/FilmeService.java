package com.jcstechnol.cinema.services;

import com.jcstechnol.cinema.dtos.FilmeDTO;
import com.jcstechnol.cinema.entities.Filme;
import com.jcstechnol.cinema.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void createFilme(FilmeDTO filmeDTO, MultipartFile capaFile) throws IOException {
        Filme filme = new Filme();
        filme.setTitulo(filmeDTO.getTitulo());
        filme.setSinopse(filmeDTO.getSinopse());
        filme.setDiretor(filmeDTO.getDiretor());
        filme.setGenero(filmeDTO.getGenero());
        filme.setDuracao(filmeDTO.getDuracao());
        filme.setClassificacao(filmeDTO.getClassificacao());
        filme.setThriller(filmeDTO.getThriller());

        if (capaFile != null && !capaFile.isEmpty()) {
            filme.setCapa(capaFile.getBytes());
        }

        filmeRepository.save(filme);
    }

    public List<Filme> getAllFilme() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> getByIdFilme(Long id) {
        return filmeRepository.findById(id);
    }

    public void updateFilme(FilmeDTO filmeDTO, MultipartFile capaFile) throws IOException {
        Optional<Filme> filmeOpt = filmeRepository.findById(filmeDTO.getId());
        if (filmeOpt.isPresent()) {
            Filme filme = filmeOpt.get();
            filme.setTitulo(filmeDTO.getTitulo());
            filme.setSinopse(filmeDTO.getSinopse());
            filme.setDiretor(filmeDTO.getDiretor());
            filme.setGenero(filmeDTO.getGenero());
            filme.setDuracao(filmeDTO.getDuracao());
            filme.setClassificacao(filmeDTO.getClassificacao());
            filme.setThriller(filmeDTO.getThriller());

            if (capaFile != null && !capaFile.isEmpty()) {
                filme.setCapa(capaFile.getBytes());
            }

            filmeRepository.save(filme);
        }
    }

    public void deleteFilme(Long id) {
        filmeRepository.deleteById(id);
    }
}
