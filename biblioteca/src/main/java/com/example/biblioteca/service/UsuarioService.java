package com.example.biblioteca.service;

import com.example.biblioteca.dao.UsuarioDAO;
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


    // LISTAR USUARIOS
    public List<Usuario> listarUsuario() throws SQLException {
        return usuarioDAO.buscarUsuario();
    }


    // ATUALIZAR USUARIO
    public Usuario atualizarUsuario(Usuario usuario, int id) throws SQLException {
        usuario.setId(id);
        usuarioDAO.atualizarUsuario(usuario);
        return usuario;
    }


    // BUSCAR POR ID
    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        return usuarioDAO.buscarPorId(id);
    }


    // DELETAR USUARIO
    public void  deletarUsuarioPorId(int id) throws SQLException {
        usuarioDAO.deletarUsuarioPorId(id);
    }
}
