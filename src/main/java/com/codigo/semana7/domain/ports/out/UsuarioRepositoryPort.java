package com.codigo.semana7.domain.ports.out;

import com.codigo.semana7.domain.model.Persona;
import com.codigo.semana7.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    Usuario update(Usuario usuario);
    void delete(Long id);
}
