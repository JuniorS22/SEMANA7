package com.codigo.semana7.application.service;

import com.codigo.semana7.domain.model.Persona;
import com.codigo.semana7.domain.ports.in.PersonaUseCase;

import java.util.Optional;

public class PersonaService implements PersonaUseCase {
    private final PersonaUseCase personaUseCase;

    public PersonaService(PersonaUseCase personaUseCase) {
        this.personaUseCase = personaUseCase;
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaUseCase.crearPersona(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaUseCase.getPersona(id);
    }
//aca hice
    @Override
    public Persona actualizarPersona(Persona persona) {
        return personaUseCase.actualizarPersona(persona);
    }

    @Override
    public void borrarPersona(Long id) {
        personaUseCase.borrarPersona(id);
    }


}
