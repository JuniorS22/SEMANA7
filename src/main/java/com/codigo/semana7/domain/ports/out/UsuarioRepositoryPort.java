package com.codigo.semana7.domain.ports.out;

import com.codigo.semana7.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    Usuario save (Usuario usuario);
}
