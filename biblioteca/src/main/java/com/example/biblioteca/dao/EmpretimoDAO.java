package com.example.biblioteca.dao;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class EmpretimoDAO {


    // SALVAR
    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String query = "INSERT INTO emprestimo (livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, emprestimo.getLivro_id());
            stmt.setInt(2, emprestimo.getUsuario_id());
            stmt.setDate(3, Date.valueOf(emprestimo.getData_emprestimo().toString()));
            stmt.setDate(4, Date.valueOf(emprestimo.getData_devolucao().toString()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()) {
                emprestimo.setId(rs.getInt(1));
                return emprestimo;
            }
        }
        return emprestimo;
    }



    // BUSCARTODOS
    public List<Emprestimo> buscarEmprestimo() throws SQLException {
        List<Emprestimo> listarEmprestimos = new ArrayList<>();
        String query = """
                SELECT
                id,
                livro_id,
                usuario_id,
                data_emprestimo,
                data_devolucao
                FROM
                emprestimo
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                listarEmprestimos.add(new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("livro_id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("data_emprestimo"),
                        rs.getDate("data_devolucao")
                ));
            }
        }
        return listarEmprestimos;
    }



    // BUSCARPORID
    public Emprestimo buscarPorId(int id) throws SQLException {
        String query = """
                SELECT id,
                livro_id,
                usuario_id,
                data_emprestimo,
                data_devolucao
                FROM emprestimo
                WHERE id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("livro_id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("data_emprestimo"),
                        rs.getDate("data_devolucao")
                );
            }
        }
        throw new RuntimeException("Emprestimo não encontrado!");
    }



    // ATUALIZAR
    public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String query = """
                UPDATE emprestimo
                set livro_id = ?,
                usuario_id = ?,
                data_emprestimo = ?,
                data_devolucao = ?
                WHERE
                id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, emprestimo.getLivro_id());
            stmt.setInt(2, emprestimo.getUsuario_id());
            stmt.setDate(3, Date.valueOf(emprestimo.getData_emprestimo().toString()));
            stmt.setDate(4, Date.valueOf(emprestimo.getData_devolucao().toString()));
            stmt.executeUpdate();

        }
        return emprestimo;
    }



    // DELETARPORID
    public void deletarEmprestimoPorId(int id) throws SQLException {
        String query = """
                DELETE FROM emprestimo
                WHERE id = ?
                """;

        try(Connection conn = Conexao.Conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
