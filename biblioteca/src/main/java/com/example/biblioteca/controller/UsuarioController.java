package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    // METODO POST
    @PostMapping
    public Usuario salvarUsuario(
            @RequestBody Usuario usuario
    ){
        try {
            return usuarioService.salvarUsuario(usuario);

        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    // METODO GET
    @GetMapping
    public List<Usuario> listarUsuario() throws SQLException {
        try {
            return usuarioService.listarUsuario();

        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }









}
