package com.example.biblioteca.dao;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.utils.Conexao;

import java.sql.*;

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
}
