package com.practicamito.practicamito.service.impl;

import com.practicamito.practicamito.model.Persona;
import com.practicamito.practicamito.repository.IPersonaRepo;
import com.practicamito.practicamito.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaImpl extends ICRUDImpl<Persona,Integer> implements IPersonaService {

    @Autowired
    private IPersonaRepo repository;

    @Override
    public JpaRepository<Persona, Integer> getRepo() {
        return repository;
    }
}
