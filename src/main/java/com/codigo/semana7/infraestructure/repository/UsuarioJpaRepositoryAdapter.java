package com.codigo.semana7.infraestructure.repository;

import com.codigo.semana7.domain.model.Usuario;
import com.codigo.semana7.domain.ports.out.UsuarioRepositoryPort;
import com.codigo.semana7.infraestructure.entity.PersonaEntity;
import com.codigo.semana7.infraestructure.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioJpaRepositoryAdapter implements UsuarioRepositoryPort {
    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioJpaRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity= UsuarioEntity.fromDomainModel(usuario);
        UsuarioEntity saveUsuarioEntity=usuarioJpaRepository.save(usuarioEntity);
        return saveUsuarioEntity.toDomainModel();
    }
}
