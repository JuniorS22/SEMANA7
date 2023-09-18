package com.codigo.semana7.infraestructure.repository;

import com.codigo.semana7.domain.model.Persona;
import com.codigo.semana7.domain.model.Usuario;
import com.codigo.semana7.infraestructure.entity.PersonaEntity;
import com.codigo.semana7.infraestructure.entity.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsuarioJpaRepositoryAdapterTest {

    @Mock
    UsuarioJpaRepository usuarioJpaRepository;
    @InjectMocks
    UsuarioJpaRepositoryAdapter usuarioJpaRepositoryAdapter;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        usuarioJpaRepositoryAdapter=new UsuarioJpaRepositoryAdapter(usuarioJpaRepository);
    }
    @Test
    void save() {
        PersonaEntity persona=new PersonaEntity(1L,"Junior","Salinas",new Date(),"Masculino");
        Usuario usuario=new Usuario(1L,"hsjr","1234","junior@gmail.com",persona);
        UsuarioEntity usuarioEntity=new UsuarioEntity(1L,"hsjr","1234","junior@gmail.com",persona);
        when(usuarioJpaRepository.save(Mockito.any(UsuarioEntity.class))).thenReturn(usuarioEntity);
        Usuario usuario1=usuarioJpaRepositoryAdapter.save(usuario);
        assertNotNull(usuario1);
        assertEquals(usuario.getId(),usuario1.getId());
        assertEquals(usuario.getNombreUsuario(),usuario1.getNombreUsuario());
        assertEquals(persona.getId(),usuario1.getPersona().getId());
    }

    @Test
    void findById() {
        Long id=1L;
        PersonaEntity persona=new PersonaEntity(1L,"Junior","Salinas",new Date(),"Masculino");
        UsuarioEntity usuarioEntity=new UsuarioEntity(1L,"hsjr","1234","junior@gmail.com",persona);
        when(usuarioJpaRepository.findById(id)).thenReturn(Optional.of(usuarioEntity));
        Optional<Usuario> usuario=usuarioJpaRepositoryAdapter.findById(id);
        assertNotNull(usuario);
        usuario.map(usuario1 -> {
           assertEquals(usuarioEntity.getId(),usuario1.getId());
           assertEquals(usuarioEntity.getPersona().getId(),usuario1.getPersona().getId());
           return true;
        });

    }

    @Test
    void update() {
        PersonaEntity persona=new PersonaEntity(1L,"Junior","Salinas",new Date(),"Masculino");
        Usuario usuario=new Usuario(1L,"hsjr","1234","junior@gmail.com",persona);
        UsuarioEntity usuarioEntity=new UsuarioEntity(1L,"hsjr","1234","junior@gmail.com",persona);
        when(usuarioJpaRepository.save(Mockito.any(UsuarioEntity.class))).thenReturn(usuarioEntity);
        Usuario usuario1=usuarioJpaRepositoryAdapter.update(usuario);
        assertNotNull(usuario1);
        assertEquals(usuario.getId(),usuario1.getId());
        assertEquals(usuario.getNombreUsuario(),usuario1.getNombreUsuario());
        assertEquals(persona.getId(),usuario1.getPersona().getId());
    }

    @Test
    void delete() {
        Long id=1L;
        usuarioJpaRepositoryAdapter.delete(id);
    }
}