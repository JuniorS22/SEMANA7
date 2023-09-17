package com.codigo.semana7.application.service;

import com.codigo.semana7.domain.model.Usuario;
import com.codigo.semana7.domain.ports.in.UsuarioUseCase;

import java.util.Optional;

public class UsuarioService implements UsuarioUseCase {
    private final UsuarioUseCase usuarioUseCase;

    public UsuarioService(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioUseCase.crearUsuario(usuario);
    }

    @Override
    public Optional<Usuario> getUsuario(Long id) {
        return usuarioUseCase.getUsuario(id);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioUseCase.actualizarUsuario(usuario);
    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioUseCase.borrarUsuario(id);
    }
}
