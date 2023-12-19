package com.agenda.telefonica.service;

import com.agenda.telefonica.model.Contato;

import java.util.List;

public interface ContatoService
{
    void add ( Contato model );
    List<Contato> getContatos();
}
