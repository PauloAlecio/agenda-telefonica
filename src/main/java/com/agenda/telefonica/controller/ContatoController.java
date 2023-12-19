package com.agenda.telefonica.controller;

import com.agenda.telefonica.model.Contato;
import com.agenda.telefonica.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/contato")
public class ContatoController
{

    private ContatoService service;

    @Autowired
    public ContatoController ( ContatoService service ) {
        this.service = service;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView modelAndView = new ModelAndView("contato/cadastro");
        modelAndView.addObject("contato",new Contato());
        return modelAndView;
    }


    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Contato contato){
        ModelAndView modelAndView = new ModelAndView("redirect:/contato");
        modelAndView.addObject("contato",new Contato());
        service.add(contato);
        return modelAndView;
     }

     @GetMapping
     public ModelAndView listar(){
         List<Contato> contatos = service.getContatos();
         ModelAndView modelAndView = new ModelAndView("contato/listar.html");
         modelAndView.addObject("contatos",contatos);

        return modelAndView;
     }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable
    Long id) {
        ModelAndView modelAndView = new ModelAndView("contato/detalhar.html");

        Contato contato = service.getById(id);
        modelAndView.addObject("contato", contato);

        return modelAndView;
    }
}
