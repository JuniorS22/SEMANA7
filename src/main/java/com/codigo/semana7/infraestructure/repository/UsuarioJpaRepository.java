package com.codigo.semana7.infraestructure.repository;

import com.codigo.semana7.domain.model.Usuario;
import com.codigo.semana7.infraestructure.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
}
