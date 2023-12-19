package com.agenda.telefonica.service.ContatoImpl;

import com.agenda.telefonica.model.Contato;
import com.agenda.telefonica.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenda.telefonica.repository.ContatoRepository;

import java.util.List;

@Service
public class ContatoServiceImpl implements ContatoService
{

    private final ContatoRepository repository;

    @Autowired
    public ContatoServiceImpl ( ContatoRepository repository ) {
        this.repository = repository;
    }

    @Override
    public void add ( Contato model ) {
        repository.save(model);
    }

    @Override
    public List<Contato> getContatos () {
        return repository.findAll();
    }

    @Override
    public Contato getById ( Long id ) {
        return repository.findById(id).get();
    }
}
