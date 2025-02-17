package com.jcstechnol.cinema.controllers;

import com.jcstechnol.cinema.dtos.SessaoDTO;
import com.jcstechnol.cinema.entities.Sessao;
import com.jcstechnol.cinema.services.FilmeService;
import com.jcstechnol.cinema.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sessoes")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private FilmeService filmeService;


    @GetMapping("/nova")
    public String pageNewSessao(Model model) {
        model.addAttribute("filmes", filmeService.getAllFilme());
        return "sessao/nova-sessao";
    }

    @PostMapping("/nova")
    public String createSessao(SessaoDTO sessaoDTO) {
        sessaoService.createSessao(sessaoDTO);
        return "redirect:/sessoes/listar";
    }

    @GetMapping("/listar")
    public String listSessoes(Model model) {
        List<Sessao> sessoes = sessaoService.getAllSessao();
        Map<String, List<Sessao>> sessoesGroup = sessoes.stream()
                .collect(Collectors.groupingBy(sessao -> sessao.getFilme().getTitulo()));
        model.addAttribute("sessoesAgrupadas", sessoesGroup);
        return "sessao/listar-sessoes";
    }

    @GetMapping("/editar/{id}")
    public String pageEditSessao(@PathVariable Long id, Model model) {
        sessaoService.getByIdSessao(id).ifPresent(sessao -> model.addAttribute("sessao", sessao));
        return "sessao/editar-sessao";
    }

    @PostMapping("/editar")
    public String updateSessao(SessaoDTO sessaoDTO) {
        sessaoService.updateSessao(sessaoDTO);
        return "redirect:/sessoes/listar";
    }

    @GetMapping("/excluir/{id}")
    public String deleteSessao(@PathVariable Long id) {
        sessaoService.deleteSessao(id);
        return "redirect:/sessoes/listar";
    }
}
