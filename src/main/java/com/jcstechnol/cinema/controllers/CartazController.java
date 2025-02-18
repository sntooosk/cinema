package com.jcstechnol.cinema.controllers;


import com.jcstechnol.cinema.entities.Poltrona;
import com.jcstechnol.cinema.entities.Sessao;
import com.jcstechnol.cinema.services.FilmeService;
import com.jcstechnol.cinema.services.PoltronaService;
import com.jcstechnol.cinema.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CartazController {

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private PoltronaService poltronaService;

    @GetMapping("/cartaz")
    public String pageCartaz(Model model) {
        model.addAttribute("filmes", filmeService.getAllFilme());
        return "cartaz.html";
    }

    @GetMapping("/cartaz/info/{id}")
    public String pageCartazInfo(@PathVariable Long id, Model model) {
        filmeService.getByIdFilme(id).ifPresent(filme -> model.addAttribute("filme", filme));
        sessaoService.getSessaoByFilmeId(id).ifPresent(sessoes -> model.addAttribute("sessoes", sessoes));

        return "cartaz_info";
    }
    @GetMapping("/cartaz/info/poltronas/{id}")
    public String escolherPoltronas(@PathVariable Long id, Model model) {
        Optional<Sessao> sessao = sessaoService.getByIdSessao(id);
        List<Poltrona> poltronasDisponiveis = poltronaService.findPoltronasBySessao(id);

        model.addAttribute("sessao" , sessao.orElse(null));
        model.addAttribute("poltronas", poltronasDisponiveis);

        return "cartaz_poltronas";
    }
}
