package com.codigo.semana7.infraestructure.controller;


import com.codigo.semana7.application.service.UsuarioService;
import com.codigo.semana7.domain.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
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

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long usuarioId){
        return usuarioService.getUsuario(usuarioId).map(usuario -> new ResponseEntity<>(usuario,HttpStatus.OK) ).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping
    public ResponseEntity<Usuario> updateUSuario(@RequestBody Usuario usuario){
        Usuario updateUsuario=usuarioService.actualizarUsuario(usuario);
        return new ResponseEntity<>(updateUsuario,HttpStatus.CREATED);
    }
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long usuarioId){
        usuarioService.borrarUsuario(usuarioId);
        return new ResponseEntity<>("Usuario eliminado",HttpStatus.OK);
    }
}
