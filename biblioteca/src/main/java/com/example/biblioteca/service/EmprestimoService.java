package com.example.biblioteca.service;

import com.example.biblioteca.dao.EmpretimoDAO;
import com.example.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmpretimoDAO empretimoDAO;

    public EmprestimoService(EmpretimoDAO empretimoDAO) {
        this.empretimoDAO = empretimoDAO;
    }


    // SALVAR EMPRESTIMO
    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) throws SQLException {
        return empretimoDAO.salvarEmprestimo(emprestimo);
    }


    // LISTAR EMPRESTIMOS
    public List<Emprestimo> listarEmprestimo() throws SQLException {
        return empretimoDAO.buscarEmprestimo();
    }


    // ATUALIZAR EMPRESTIMO
    public Emprestimo atualizarEmprestimo(Emprestimo emprestimo, int id) throws SQLException {
        emprestimo.setId(id);
        empretimoDAO.atualizarEmprestimo(emprestimo);
        return emprestimo;
    }


    // BUSCAR POR ID
    public Emprestimo buscarEmprestimoPorId(int id) throws SQLException {
        return empretimoDAO.buscarPorId(id);
    }


    // DELETAR EMPRESTIMO
    public void  deletarEmprestimoPorId(int id) throws SQLException {
        empretimoDAO.deletarEmprestimoPorId(id);
    }
}
