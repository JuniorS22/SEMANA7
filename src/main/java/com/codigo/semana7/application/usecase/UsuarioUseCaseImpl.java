package com.codigo.semana7.application.usecase;

import com.codigo.semana7.domain.model.Usuario;
import com.codigo.semana7.domain.ports.in.UsuarioUseCase;
import com.codigo.semana7.domain.ports.out.UsuarioRepositoryPort;

public class UsuarioUseCaseImpl implements UsuarioUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepositoryPort.save(usuario);
    }
}
