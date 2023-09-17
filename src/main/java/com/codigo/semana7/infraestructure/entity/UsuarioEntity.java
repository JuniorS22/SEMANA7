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
    private long id;
    private String nombreUsuario;
    private String contraseña;
    private String correElectronico;
    @OneToOne
    private Persona persona_id;

    public UsuarioEntity() {
    }

    public UsuarioEntity(long id, String nombreUsuario, String contraseña, String correElectronico, Persona persona_id) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correElectronico = correElectronico;
        this.persona_id = persona_id;
    }

    public static UsuarioEntity fromDomainModel(Usuario usuario){
        return new UsuarioEntity(usuario.getId(),usuario.getNombreUsuario(),usuario.getContraseña(),usuario.getCorreElectronico(),usuario.getPersona_id());
    }
    public Usuario toDomainModel(){
        return new Usuario(id,nombreUsuario,contraseña,correElectronico,persona_id);
    }
}
