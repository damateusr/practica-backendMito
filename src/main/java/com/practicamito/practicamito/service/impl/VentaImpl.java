package com.practicamito.practicamito.service.impl;

import com.practicamito.practicamito.model.Venta;
import com.practicamito.practicamito.repository.IVentaRepo;
import com.practicamito.practicamito.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class VentaImpl extends ICRUDImpl<Venta,Integer> implements IVentaService {

    @Autowired
    private IVentaRepo repo;

    @Override
    public JpaRepository<Venta, Integer> getRepo() {
        return repo;
    }
}
