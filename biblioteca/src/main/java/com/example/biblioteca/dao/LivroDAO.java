package com.example.biblioteca.dao;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;


@Repository
public class LivroDAO {


    // SALVAR
    public Livro salvarLivro(Livro livro) throws SQLException {
        String query = "INSERT INTO livro (titulo, autor, ano_publicacao) VALUES (?,?,?)";

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()) {
                livro.setId(rs.getInt(1));
            }
        }
        return livro;
    }

    // BUSCARTODOS
    // BUSCARPORID
    // ATUALIZAR
    // DELETAR



}
