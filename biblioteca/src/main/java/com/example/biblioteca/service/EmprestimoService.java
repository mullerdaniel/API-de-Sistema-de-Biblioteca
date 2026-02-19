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











}
