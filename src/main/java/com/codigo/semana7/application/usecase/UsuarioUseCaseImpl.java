package com.codigo.semana7.application.usecase;

import com.codigo.semana7.domain.model.Usuario;
import com.codigo.semana7.domain.ports.in.UsuarioUseCase;
import com.codigo.semana7.domain.ports.out.UsuarioRepositoryPort;

import java.util.Optional;

public class UsuarioUseCaseImpl implements UsuarioUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepositoryPort.save(usuario);
    }

    @Override
    public Optional<Usuario> getUsuario(Long id) {
        return usuarioRepositoryPort.findById(id);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepositoryPort.update(usuario);
    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioRepositoryPort.delete(id);
    }
}
