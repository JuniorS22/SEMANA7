package com.codigo.semana7.infraestructure.controller;

import com.codigo.semana7.application.service.UsuarioService;
import com.codigo.semana7.domain.model.Persona;
import com.codigo.semana7.domain.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario createUsuario=usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(createUsuario, HttpStatus.CREATED);
    }
}
