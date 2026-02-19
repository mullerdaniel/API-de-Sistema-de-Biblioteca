package com.example.biblioteca.service;

import com.example.biblioteca.dao.LivroDAO;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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


    // LISTAR LIVROS
    public List<Livro> listarLivro() throws SQLException {
        return livroDAO.buscarLivro();
    }


    // ATUALIZAR LIVRO
    public Livro atualizarLivro(Livro livro, int id) throws SQLException {
        livro.setId(id);
        livroDAO.atualizarLivro(livro);
        return livro;
    }


    // BUSCAR POR ID
    public Livro buscarLivroPorId(int id) throws SQLException {
        return livroDAO.buscarPorId(id);
    }
}
