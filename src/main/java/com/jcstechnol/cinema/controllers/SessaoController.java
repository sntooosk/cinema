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

@Controller
@RequestMapping("/sessoes")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/nova")
    public String showCreateSessaoPage(Model model) {
        model.addAttribute("filmes", filmeService.listarFilmes());
        return "nova-sessao";
    }

    @PostMapping("/nova")
    public String createSessao(SessaoDTO sessaoDTO) {
        sessaoService.salvarSessao(sessaoDTO);
        return "redirect:/sessoes/listar";
    }

    @GetMapping("/listar")
    public String listSessoes(Model model) {
        List<Sessao> sessoes = sessaoService.listarSessoes();
        model.addAttribute("sessoes", sessoes);
        return "listar-sessoes";
    }

    @GetMapping("/editar/{id}")
    public String showEditSessaoPage(@PathVariable Long id, Model model) {
        sessaoService.obterSessao(id).ifPresent(sessao -> model.addAttribute("sessao", sessao));
        return "editar-sessao";
    }

    @PostMapping("/editar")
    public String updateSessao(SessaoDTO sessaoDTO) {
        sessaoService.atualizarSessao(sessaoDTO);
        return "redirect:/sessoes/listar";
    }

    @GetMapping("/excluir/{id}")
    public String deleteSessao(@PathVariable Long id) {
        sessaoService.excluirSessao(id);
        return "redirect:/sessoes/listar";
    }
}
