package com.practicamito.practicamito.controller;

import com.practicamito.practicamito.dto.DetalleVentaDTO;
import com.practicamito.practicamito.dto.VentaDTO;
import com.practicamito.practicamito.exception.ModeloNotFoundException;
import com.practicamito.practicamito.model.DetalleVenta;
import com.practicamito.practicamito.model.Persona;
import com.practicamito.practicamito.model.Venta;
import com.practicamito.practicamito.service.IDetalleService;
import com.practicamito.practicamito.service.IPersonaService;
import com.practicamito.practicamito.service.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private IVentaService service;

    @Autowired
    private IPersonaService personaServ;

    @Autowired
    private IDetalleService serviceDetVta;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<VentaDTO>>listar() throws Exception {
        List<VentaDTO> lista = service.listar().stream().map(p -> modelMapper.map(p, VentaDTO.class)).collect(Collectors.toList());
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDTO>listarPorId(@PathVariable("id") Integer idVenta) throws Exception {
        VentaDTO dtoResponse = null;
        Venta p = service.listarPorID(idVenta);
        if(p == null) {
            throw new ModeloNotFoundException("ID DEL Venta " + idVenta +" NO ENCONTRADO");
        }else {
            dtoResponse = modelMapper.map(p, VentaDTO.class);
            return new ResponseEntity(dtoResponse, HttpStatus.OK);
        }

    }
    @Transactional
    @PostMapping
    public ResponseEntity<VentaDTO> registar(@RequestBody VentaDTO dtoVenta) throws Exception {

         //dtoResponse = null;
        //Persona p = personaServ.listarPorID(dtoVenta.getIdPersona().getIdPersona());
        Persona p = new Persona();
        p.setNombre(dtoVenta.getPersona().getNombre());
        p.setApellidos(dtoVenta.getPersona().getApellidos());
        personaServ.registrar(p);

        dtoVenta.getPersona().setIdPersona(p.getIdPersona());
        Venta vta = modelMapper.map(dtoVenta, Venta.class);
        service.registrar(vta);
        VentaDTO dtoResponse = modelMapper.map(vta, VentaDTO.class);

        List<DetalleVentaDTO> lisDetVta = dtoVenta.getDetVta();
        lisDetVta.stream().forEach( det -> {
            try {
                det.setIdVenta(vta);
                serviceDetVta.registrar( modelMapper.map(det,DetalleVenta.class) );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //detVta.setIdVenta(vta);
        //DetalleVenta detVt = modelMapper.map(detVta,DetalleVenta.class);
        //serviceDetVta.registrar(detVt);


        return new ResponseEntity(dtoResponse, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<VentaDTO> modificar(@RequestBody VentaDTO dtoVenta) throws Exception {

        Venta p = service.listarPorID(dtoVenta.getIdVenta());

        if ( p == null ){
            throw new ModeloNotFoundException("ID DE Venta " + dtoVenta.getIdVenta() + " NO ENCONTRADO");
        }

        Venta per = modelMapper.map(dtoVenta, Venta.class);
        Venta perTemp = service.modificar(per);
        VentaDTO dtoResponse = modelMapper.map(perTemp, VentaDTO.class);

        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VentaDTO>borrar(@PathVariable("id") Integer idVenta) throws Exception {
        service.eliminar(idVenta);
        return new ResponseEntity(HttpStatus.OK);
    }

}
