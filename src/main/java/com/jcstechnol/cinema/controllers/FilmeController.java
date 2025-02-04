package com.jcstechnol.cinema.controllers;

import com.jcstechnol.cinema.dtos.FilmeDTO;
import com.jcstechnol.cinema.entities.Filme;
import com.jcstechnol.cinema.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/novo")
    public String showCreateFilmePage() {
        return "novo-filme";
    }

    @PostMapping("/novo")
    public String createFilme(FilmeDTO filmeDTO, @RequestParam("capa") MultipartFile capaFile) throws IOException {
        filmeService.salvarFilme(filmeDTO, capaFile);
        return "redirect:/filmes/listar";
    }

    @GetMapping("/listar")
    public String listFilmes(Model model) {
        model.addAttribute("filmes", filmeService.listarFilmes());
        return "listar-filmes";
    }

    @GetMapping("/editar/{id}")
    public String showEditFilmePage(@PathVariable Long id, Model model) {
        filmeService.obterFilme(id).ifPresent(filme -> model.addAttribute("filme", filme));
        return "editar-filme";
    }

    @PostMapping("/editar")
    public String updateFilme(FilmeDTO filmeDTO, @RequestParam(value = "capa", required = false) MultipartFile capaFile) throws IOException {
        filmeService.atualizarFilme(filmeDTO, capaFile);
        return "redirect:/filmes/listar";
    }

    @GetMapping("/excluir/{id}")
    public String deleteFilme(@PathVariable Long id) {
        filmeService.excluirFilme(id);
        return "redirect:/filmes/listar";
    }

    @GetMapping("/capa/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getCapa(@PathVariable Long id) {
        return filmeService.obterFilme(id)
                .filter(filme -> filme.getCapa() != null)
                .map(filme -> ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(filme.getCapa()))
                .orElse(ResponseEntity.notFound().build());
    }
}
