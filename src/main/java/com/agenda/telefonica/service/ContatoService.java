package com.agenda.telefonica.service;

import com.agenda.telefonica.model.Contato;

public interface ContatoService
{
    default void add ( Contato model ){}
}
