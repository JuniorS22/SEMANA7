package com.codigo.semana7.infraestructure.repository;

import com.codigo.semana7.domain.model.Persona;
import com.codigo.semana7.infraestructure.entity.PersonaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonaJpaRepositoryAdapterTest {

    @Mock
    PersonaJpaRepository personaJpaRepository;

    @InjectMocks
    PersonaJpaRepositoryAdapter personaJpaRepositoryAdapter;
    @Test
    void save() {
    }

    @Test
    void findById() {
    }
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        personaJpaRepositoryAdapter=new PersonaJpaRepositoryAdapter(personaJpaRepository);
    }
    @Test
    void saveExitosoPersonaEntity(){
        Persona persona= new Persona(1L,"Junior","Salinas",new Date(),"Masculino");
        PersonaEntity personaEntity= new PersonaEntity(1L,"Junior","Salinas",new Date(),"Masculino");
        when(personaJpaRepository.save(Mockito.any(PersonaEntity.class))).thenReturn(personaEntity);
        Persona personaAdapter=personaJpaRepositoryAdapter.save(persona);
        assertNotNull(personaAdapter);
        assertEquals(persona.getId(),personaAdapter.getId());
        assertEquals(persona.getNombre(),personaAdapter.getNombre());
    }
    @Test
    void acutalizarExitoso(){
        Persona persona= new Persona(1L,"Junior","Salinas",new Date(),"Masculino");
        PersonaEntity personaEntity= new PersonaEntity(1L,"Junior","Salinas",new Date(),"Masculino");
        when(personaJpaRepository.save(Mockito.any(PersonaEntity.class))).thenReturn(personaEntity);
        Persona personaAdapter=personaJpaRepositoryAdapter.update(persona);
        assertNotNull(personaAdapter);
        assertEquals(persona.getId(),personaAdapter.getId());
        assertEquals(persona.getNombre(),personaAdapter.getNombre());
    }
}