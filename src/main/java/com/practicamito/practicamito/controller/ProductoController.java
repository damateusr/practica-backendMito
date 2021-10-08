package com.practicamito.practicamito.controller;

import com.practicamito.practicamito.dto.ProductoDTO;
import com.practicamito.practicamito.exception.ModeloNotFoundException;
import com.practicamito.practicamito.model.Producto;
import com.practicamito.practicamito.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>>listar() throws Exception {
        List<ProductoDTO> lista = service.listar().stream().map(p -> modelMapper.map(p, ProductoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO>listarPorId(@PathVariable("id") Integer idProducto) throws Exception {
        ProductoDTO dtoResponse = null;
        Producto p = service.listarPorID(idProducto);
        if(p == null) {
            throw new ModeloNotFoundException("ID DEL PRODUCTO " + idProducto +" NO ENCONTRADO");
        }else {
            dtoResponse = modelMapper.map(p, ProductoDTO.class);
            return new ResponseEntity(dtoResponse, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<ProductoDTO> registar(@RequestBody ProductoDTO dtoProducto) throws Exception {
        Producto per = modelMapper.map(dtoProducto, Producto.class);
        Producto p = service.registrar(per);
        ProductoDTO dtoResponse = modelMapper.map(p, ProductoDTO.class);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> modificar(@RequestBody ProductoDTO dtoProducto) throws Exception {

        Producto p = service.listarPorID(dtoProducto.getIdProducto());

        if ( p == null ){
            throw new ModeloNotFoundException("ID DE Producto " + dtoProducto.getIdProducto() + " NO ENCONTRADO");
        }

        Producto per = modelMapper.map(dtoProducto, Producto.class);
        Producto perTemp = service.modificar(per);
        ProductoDTO dtoResponse = modelMapper.map(perTemp, ProductoDTO.class);

        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDTO>borrar(@PathVariable("id") Integer idProducto) throws Exception {
        service.eliminar(idProducto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
