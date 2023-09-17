package com.codigo.semana7.infraestructure.entity;


import com.codigo.semana7.domain.model.Persona;
import com.codigo.semana7.domain.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreUsuario;
    private String contrasena;
    private String correoElectronico;
    @OneToOne
    private PersonaEntity persona;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nombreUsuario, String contrasena, String correoElectronico, PersonaEntity persona) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.persona = persona;
    }

    public static UsuarioEntity fromDomainModel(Usuario usuario){
        return new UsuarioEntity(usuario.getId(), usuario.getNombreUsuario(), usuario.getContrasena(), usuario.getCorreoElectronico(), usuario.getPersona());
    }
    public Usuario toDomainModel(){
        return new Usuario(id,nombreUsuario,contrasena,correoElectronico,persona);
    }
}
