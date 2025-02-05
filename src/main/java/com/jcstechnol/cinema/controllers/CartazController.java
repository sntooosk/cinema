package com.jcstechnol.cinema.controllers;


import com.jcstechnol.cinema.services.FilmeService;
import com.jcstechnol.cinema.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartazController {

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private SessaoService sessaoService;


    @GetMapping("/cartaz")
    public String showHomePage(Model model) {
        model.addAttribute("filmes", filmeService.listarFilmes());
        return "cartaz.html";
    }

    @GetMapping("/cartaz/info/{id}")
    public String showFilmeDetails(@PathVariable Long id, Model model) {
        filmeService.obterFilme(id).ifPresent(filme -> model.addAttribute("filme", filme));
        sessaoService.listarSessoesPorFilme(id).ifPresent(sessoes -> model.addAttribute("sessoes", sessoes));

        return "cartaz_info";
    }
}
