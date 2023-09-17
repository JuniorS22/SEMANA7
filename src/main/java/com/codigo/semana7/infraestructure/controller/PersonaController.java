package com.codigo.semana7.infraestructure.controller;

import com.codigo.semana7.application.service.PersonaService;
import com.codigo.semana7.domain.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personas")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona){
        Persona createPersona=personaService.crearPersona(persona);
        return new ResponseEntity<>(createPersona, HttpStatus.CREATED);
    }
    @GetMapping("/{personaId}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long personaId){
        return personaService.getPersona(personaId).map(persona -> new ResponseEntity<>(persona,HttpStatus.OK) ).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona){
        Persona actualizarPersona=personaService.actualizarPersona(persona);
        return new ResponseEntity<>(actualizarPersona, HttpStatus.CREATED);
    }
    @DeleteMapping("/{personaId}")
    public ResponseEntity<String> deletePersona(@PathVariable Long personaId){
        personaService.borrarPersona(personaId);
        return new ResponseEntity<>("Persona eliminada", HttpStatus.OK);
    }
}
