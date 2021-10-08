package com.practicamito.practicamito.service.impl;

import com.practicamito.practicamito.model.Producto;
import com.practicamito.practicamito.repository.IProductoRepo;
import com.practicamito.practicamito.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoImpl extends ICRUDImpl<Producto,Integer> implements IProductoService {

    @Autowired
    private IProductoRepo repo;

    @Override
    public JpaRepository<Producto, Integer> getRepo() {
        return repo;
    }
}
