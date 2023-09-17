package com.codigo.semana7.application.service;

import com.codigo.semana7.domain.model.Usuario;
import com.codigo.semana7.domain.ports.in.UsuarioUseCase;

public class UsuarioService implements UsuarioUseCase {
    private final UsuarioUseCase usuarioUseCase;

    public UsuarioService(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioUseCase.crearUsuario(usuario);
    }
}
