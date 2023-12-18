package com.agenda.telefonica.service.ContatoImpl;

import com.agenda.telefonica.model.Contato;
import com.agenda.telefonica.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ContatoRepository;

@Service
public class ContatoServiceImpl implements ContatoService
{
    private ContatoRepository repository;

    @Autowired
    public ContatoServiceImpl ( ContatoRepository repository ) {
        this.repository = repository;
    }

    @Override
    public void add ( Contato model ) {
        repository.save(model);
    }
}
