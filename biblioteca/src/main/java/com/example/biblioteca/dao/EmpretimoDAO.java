package com.example.biblioteca.dao;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.utils.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;


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



}
