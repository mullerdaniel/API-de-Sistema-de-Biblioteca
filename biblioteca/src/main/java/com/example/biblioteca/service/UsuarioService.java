package com.example.biblioteca.service;

import com.example.biblioteca.dao.UsuarioDAO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }


    // SALVAR USUARIO
    public Usuario salvarUsuario(Usuario usuario) throws SQLException {
        return usuarioDAO.salvarUsuario(usuario);
    }












}
