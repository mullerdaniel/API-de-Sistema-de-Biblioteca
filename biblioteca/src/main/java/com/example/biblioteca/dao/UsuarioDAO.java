package com.example.biblioteca.dao;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDAO {

    // SALVAR
    public Usuario salvarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nome, email) VALUES (?,?)";

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()) {
                usuario.setId(rs.getInt(1));
                return usuario;
            }
        }
        return usuario;
    }



    // BUSCARTODOS
    public List<Usuario> buscarUsuario() throws SQLException {
        List<Usuario> listarUsuarios = new ArrayList<>();
        String query = """
                SELECT
                id,
                nome,
                email
                FROM
                usuario
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                listarUsuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                ));
            }
        }
        return listarUsuarios;
    }



    // BUSCARPORID
    public Usuario buscarPorId(int id) throws SQLException {
        String query = """
                SELECT id,
                nome,
                email
                FROM usuario
                WHERE id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
            }
        }
        throw new RuntimeException("Usuario não encontrado!");
    }



    // ATUALIZAR
    public Usuario atualizarUsuario(Usuario usuario) throws SQLException {
        String query = """
                UPDATE usuario
                set nome = ?,
                email = ?
                WHERE
                id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();

        }
        return usuario;
    }



    // DELETARPORID
    public void deletarUsuarioPorId(int id) throws SQLException {
        String query = """
                DELETE FROM usuario
                WHERE id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
