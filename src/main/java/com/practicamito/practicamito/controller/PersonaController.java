package com.practicamito.practicamito.controller;

import com.practicamito.practicamito.dto.PersonaDTO;
import com.practicamito.practicamito.exception.ModeloNotFoundException;
import com.practicamito.practicamito.model.Persona;
import com.practicamito.practicamito.service.IPersonaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>>listar() throws Exception {
        List<PersonaDTO> lista = service.listar().stream().map(p -> modelMapper.map(p, PersonaDTO.class)).collect(Collectors.toList());
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO>listarPorId(@PathVariable("id") Integer idPersona) throws Exception {
        PersonaDTO dtoResponse = null;
        Persona p = service.listarPorID(idPersona);
        if(p == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + idPersona);
        }else {
            dtoResponse = modelMapper.map(p, PersonaDTO.class);
            return new ResponseEntity(dtoResponse, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<PersonaDTO> registar(@RequestBody PersonaDTO dtoPersona) throws Exception {
        Persona per = modelMapper.map(dtoPersona, Persona.class);
        Persona p = service.registrar(per);
        PersonaDTO dtoResponse = modelMapper.map(p, PersonaDTO.class);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PersonaDTO> modificar(@RequestBody PersonaDTO dtoPersona) throws Exception {

        Persona p = service.listarPorID(dtoPersona.getIdPersona());

        if ( p == null ){
            throw new ModeloNotFoundException("ID DE PERSONA " + dtoPersona.getIdPersona() + " NO ENCONTRADO");
        }

        Persona per = modelMapper.map(dtoPersona, Persona.class);
        Persona perTemp = service.modificar(per);
        PersonaDTO dtoResponse = modelMapper.map(perTemp, PersonaDTO.class);

        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaDTO>borrar(@PathVariable("id") Integer idPersona) throws Exception {
        service.eliminar(idPersona);
        return new ResponseEntity(HttpStatus.OK);
    }

}
