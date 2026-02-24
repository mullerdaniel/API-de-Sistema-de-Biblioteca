package com.example.biblioteca.service;

import com.example.biblioteca.Dto.EmprestimoRequisicaoDto;
import com.example.biblioteca.Dto.EmprestimoRespostaDto;
import com.example.biblioteca.dao.EmprestimoDAO;
import com.example.biblioteca.dao.LivroDAO;
import com.example.biblioteca.mapper.EmprestimoMapper;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoDAO emprestimoDAO;
    private final LivroDAO livroDAO;

    private final EmprestimoMapper emprestimoMapper;

    public EmprestimoService(EmprestimoDAO emprestimoDAO, LivroDAO livroDAO, EmprestimoMapper emprestimoMapper) {
        this.emprestimoDAO = emprestimoDAO;
        this.livroDAO = livroDAO;
        this.emprestimoMapper = emprestimoMapper;
    }



    // SALVAR EMPRESTIMO
    public EmprestimoRespostaDto salvarEmprestimo(EmprestimoRequisicaoDto emprestimoRequisicaoDto) throws SQLException {
        Emprestimo emprestimo = emprestimoMapper.paraEntidade(emprestimoRequisicaoDto);

        Livro livro = livroDAO.buscarPorId(emprestimo.getLivro_id());
        if (livro == null) {
            throw new SQLException("Livro não encontrado para o ID: " + emprestimo.getLivro_id());
        }

        emprestimo.setLivro(livro);
        emprestimo.setLivro_id(livro.getId());

        Emprestimo emprestimoSalvo = emprestimoDAO.salvarEmprestimo(emprestimo);

        EmprestimoRespostaDto emprestimoRespostaDto = emprestimoMapper.paraRespostaDto(emprestimoSalvo);

        return emprestimoRespostaDto;
    }



    // LISTAR EMPRESTIMOS
    public List<Emprestimo> listarEmprestimo() throws SQLException {
        return emprestimoDAO.buscarEmprestimo();
    }



    // ATUALIZAR EMPRESTIMO
    public Emprestimo atualizarEmprestimo(Emprestimo emprestimo, int id) throws SQLException {
        Emprestimo existente = emprestimoDAO.buscarPorId(id);
        if (existente == null) {
            throw new SQLException("Emprestimo não encontrado para ID: " + id);
        }
        emprestimo.setId(id);
        return emprestimoDAO.atualizarEmprestimo(emprestimo);
    }



    // BUSCAR POR ID
    public Emprestimo buscarEmprestimoPorId(int id) throws SQLException {
        return emprestimoDAO.buscarPorId(id);
    }



    // DELETAR EMPRESTIMO
    public void deletarEmprestimoPorId(int id) throws SQLException {
        emprestimoDAO.deletarEmprestimoPorId(id);
    }
}
