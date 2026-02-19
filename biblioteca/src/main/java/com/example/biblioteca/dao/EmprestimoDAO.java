package com.example.biblioteca.dao;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmprestimoDAO {



    // SALVAR
    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String query = "INSERT INTO emprestimo (livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?,?,?,?)";

        try (Connection conn = Conexao.Conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, emprestimo.getLivro_id());
            stmt.setInt(2, emprestimo.getUsuario_id());
            stmt.setDate(3, emprestimo.getData_emprestimo() != null ? Date.valueOf(emprestimo.getData_emprestimo()) : null);
            stmt.setDate(4, emprestimo.getData_devolucao() != null ? Date.valueOf(emprestimo.getData_devolucao()) : null);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                emprestimo.setId(rs.getInt(1));
            }
        }
        return emprestimo;
    }



    // BUSCAR TODOS
    public List<Emprestimo> buscarEmprestimo() throws SQLException {
        List<Emprestimo> listarEmprestimos = new ArrayList<>();
        String query = "SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao FROM emprestimo";

        try (Connection conn = Conexao.Conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listarEmprestimos.add(new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("livro_id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getDate("data_devolucao").toLocalDate()
                ));
            }
        }
        return listarEmprestimos;
    }



    // BUSCAR POR ID
    public Emprestimo buscarPorId(int id) throws SQLException {
        String query = "SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao FROM emprestimo WHERE id = ?";

        try (Connection conn = Conexao.Conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Emprestimo(
                            rs.getInt("id"),
                            rs.getInt("livro_id"),
                            rs.getInt("usuario_id"),
                            rs.getDate("data_emprestimo").toLocalDate(),
                            rs.getDate("data_devolucao").toLocalDate()
                    );
                }
            }
        }
        return null;
    }



    // ATUALIZAR
    public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String query = "UPDATE emprestimo SET livro_id = ?, usuario_id = ?, data_emprestimo = ?, data_devolucao = ? WHERE id = ?";

        try (Connection conn = Conexao.Conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, emprestimo.getLivro_id());
            stmt.setInt(2, emprestimo.getUsuario_id());
            stmt.setDate(3, emprestimo.getData_emprestimo() != null ? Date.valueOf(emprestimo.getData_emprestimo()) : null);
            stmt.setDate(4, emprestimo.getData_devolucao() != null ? Date.valueOf(emprestimo.getData_devolucao()) : null);
            stmt.setInt(5, emprestimo.getId());

            stmt.executeUpdate();
        }
        return emprestimo;
    }



    // DELETAR POR ID
    public void deletarEmprestimoPorId(int id) throws SQLException {
        String query = "DELETE FROM emprestimo WHERE id = ?";

        try (Connection conn = Conexao.Conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
