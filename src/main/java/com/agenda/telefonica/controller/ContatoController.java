package com.agenda.telefonica.controller;

import com.agenda.telefonica.model.Contato;
import com.agenda.telefonica.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContatoController
{

    private ContatoService service;

    @Autowired
    public ContatoController ( ContatoService service ) {
        this.service = service;
    }

    @GetMapping("/contato")
    public String getForm( Model model ){
        model.addAttribute("contato",new Contato());
        return "contato";
    }


    @PostMapping("/contato")
    public String submmit(@ModelAttribute Contato contato, Model model ){
        model.addAttribute("contato",contato);
        service.add(contato);
        return "detalhe";
     }

     @GetMapping("/contatos")
     public String getAll(Model model){
        model.addAttribute("contatos",service.getContatos());

        return "contatos";
     }

}
