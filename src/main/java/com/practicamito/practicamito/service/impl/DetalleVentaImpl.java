package com.practicamito.practicamito.service.impl;

import com.practicamito.practicamito.model.DetalleVenta;
import com.practicamito.practicamito.repository.IDetalleVentaRepo;
import com.practicamito.practicamito.service.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaImpl extends ICRUDImpl<DetalleVenta,Integer> implements IDetalleService {


    @Autowired
    private IDetalleVentaRepo repo;

    @Override
    public JpaRepository<DetalleVenta, Integer> getRepo() {
        return repo;
    }
}
