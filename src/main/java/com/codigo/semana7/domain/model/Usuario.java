package com.codigo.semana7.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import java.util.Date;
@Getter
@Setter
public class Usuario {
    private long id;
    private String nombreUsuario;
    private String contraseña;
    private String correElectronico;
    Persona persona_id;

    public Usuario(long id, String nombreUsuario, String contrasena, String correElectronico, Persona persona_id) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contrasena;
        this.correElectronico = correElectronico;
        this.persona_id = persona_id;
    }
}
