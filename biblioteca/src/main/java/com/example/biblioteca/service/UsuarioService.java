package com.example.biblioteca.service;

import com.example.biblioteca.Dto.UsuarioRequisicaoDto;
import com.example.biblioteca.Dto.UsuarioRespostaDto;
import com.example.biblioteca.dao.UsuarioDAO;
import com.example.biblioteca.mapper.UsuarioMapper;
import com.example.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioDAO usuarioDAO, UsuarioMapper usuarioMapper) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioMapper = usuarioMapper;
    }


    // SALVAR USUARIO
    public UsuarioRespostaDto salvarUsuario(UsuarioRequisicaoDto usuarioRequisicaoDto) throws SQLException {
        Usuario usuario = usuarioMapper.paraEntidade(usuarioRequisicaoDto);
        Usuario usuarioSalvo = usuarioDAO.salvarUsuario(usuario);
        UsuarioRespostaDto usuarioRespostaDto = usuarioMapper.paraRespostaDto(usuarioSalvo);
        return usuarioRespostaDto;
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
