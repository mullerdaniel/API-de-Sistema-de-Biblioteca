package com.example.biblioteca.dao;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
                return livro;
            }
        }
        return livro;
    }



    // BUSCARTODOS
    public List<Livro> buscarLivro() throws SQLException {
        List<Livro> listarLivros = new ArrayList<>();
        String query = """
                SELECT
                id,
                titulo,
                autor,
                ano_publicacao
                FROM
                livro
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                listarLivros.add(new Livro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("ano_publicacao")
                        ));
            }
        }
        return listarLivros;
    }



    // BUSCARPORID
    public Livro buscarPorId(int id) throws SQLException {
        String query = """
                SELECT id,
                titulo,
                autor,
                ano_publicacao
                FROM livro
                WHERE id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao")
                );
            }
        }
        throw new RuntimeException("Livro não encontrado!");
    }



    // ATUALIZAR
    public Livro atualizarLivro(Livro livro) throws SQLException {
        String query = """
                UPDATE livro
                set titulo = ?,
                autor = ?,
                ano_publicacao = ?
                WHERE
                id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());
            stmt.executeUpdate();

        }
        return livro;
    }



    // DELETARPORID
    public void deletarLivroPorId(int id) throws SQLException {
        String query = """
                DELETE FROM livro
                WHERE id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }



}
