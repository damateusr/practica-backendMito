package com.practicamito.practicamito.repository;

import com.practicamito.practicamito.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {
}
