package com.codigo.semana7.domain.model;

import com.codigo.semana7.infraestructure.entity.PersonaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private Long id;
    private String nombreUsuario;
    private String contrasena;
    private String correoElectronico;
    private PersonaEntity persona;

    public Usuario(Long id, String nombreUsuario, String contrasena, String correoElectronico, PersonaEntity persona) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.persona = persona;
    }
}
