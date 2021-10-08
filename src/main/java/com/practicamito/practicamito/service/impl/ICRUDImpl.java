package com.practicamito.practicamito.service.impl;

import com.practicamito.practicamito.service.ICRUD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class ICRUDImpl<T,ID> implements ICRUD<T,ID> {

    public abstract JpaRepository<T,ID> getRepo();

    @Override
    public T registrar(T obj) throws Exception {
        return this.getRepo().save(obj);
    }

    @Override
    public T modificar(T obj) throws Exception {
        return this.getRepo().save(obj);
    }

    @Override
    public List listar() throws Exception {
        return this.getRepo().findAll();
    }

    @Override
    public T listarPorID(ID id) throws Exception {
        return this.getRepo().getById(id);
    }

    @Override
    public void eliminar(ID idpersona) throws Exception {
        this.getRepo().deleteById(idpersona);
    }
}
