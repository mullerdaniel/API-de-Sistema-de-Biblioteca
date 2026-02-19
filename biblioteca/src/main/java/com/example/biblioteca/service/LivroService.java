package com.example.biblioteca.service;

import com.example.biblioteca.dao.LivroDAO;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LivroService {

    private final LivroDAO livroDAO;

    public LivroService(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }


    // SALVAR LIVRO
    public Livro salvarLivro(Livro livro) throws SQLException {
        return livroDAO.salvarLivro(livro);
    }
}
