package com.jcstechnol.cinema.controllers;

import com.jcstechnol.cinema.entities.Poltrona;
import com.jcstechnol.cinema.services.PoltronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/poltronas")
public class PoltronaController {

    @Autowired
    private PoltronaService poltronaService;


    @PostMapping("/atualizar/{id}")
    public String atualizarPoltrona(@PathVariable Long id, @ModelAttribute Poltrona poltrona) {
        poltronaService.atualizar(id, poltrona);
        return "redirect:/poltronas";
    }
}

