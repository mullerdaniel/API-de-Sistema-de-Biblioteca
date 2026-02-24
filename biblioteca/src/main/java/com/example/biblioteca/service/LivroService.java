package com.example.biblioteca.service;

import com.example.biblioteca.Dto.LivroRequisicaoDto;
import com.example.biblioteca.Dto.LivroRespostaDto;
import com.example.biblioteca.dao.LivroDAO;
import com.example.biblioteca.mapper.LivroMapper;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO livroDAO;

    private final LivroMapper livroMapper;

    public LivroService(LivroDAO livroDAO, LivroMapper livroMapper) {
        this.livroDAO = livroDAO;
        this.livroMapper = livroMapper;
    }


    // SALVAR LIVRO
    public LivroRespostaDto salvarLivro(LivroRequisicaoDto livroRequisicaoDto) throws SQLException {
        Livro livro = livroMapper.paraEntidade(livroRequisicaoDto);
        Livro livroSalvo = livroDAO.salvarLivro(livro);
        LivroRespostaDto livroRespostaDto = livroMapper.paraRespostaDto(livroSalvo);

        return livroRespostaDto;
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


    // DELETAR LIVRO
    public void  deletarLivroPorId(int id) throws SQLException {
        livroDAO.deletarLivroPorId(id);
    }
}
