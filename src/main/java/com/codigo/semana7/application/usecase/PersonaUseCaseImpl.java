package com.codigo.semana7.application.usecase;

import com.codigo.semana7.domain.model.Persona;
import com.codigo.semana7.domain.ports.in.PersonaUseCase;
import com.codigo.semana7.domain.ports.out.PersonaRepositoryPort;

import java.util.Optional;

public class PersonaUseCaseImpl implements PersonaUseCase {

    private  final PersonaRepositoryPort personaRepositoryPort;

    public PersonaUseCaseImpl(PersonaRepositoryPort personaRepositoryPort) {
        this.personaRepositoryPort = personaRepositoryPort;
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepositoryPort.save(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaRepositoryPort.findById(id);
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return personaRepositoryPort.update(persona);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepositoryPort.delete(id);
    }


}
