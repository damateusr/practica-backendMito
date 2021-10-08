package com.practicamito.practicamito.service;

import java.util.List;

public interface ICRUD<T,ID> {

    T registrar(T obj) throws Exception;
    T modificar(T obj) throws Exception;
    List<T> listar() throws Exception;
    T listarPorID(ID t) throws Exception;
    void eliminar(ID idpersona) throws Exception;

}
