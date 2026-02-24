package com.example.biblioteca.mapper;

import com.example.biblioteca.Dto.EmprestimoRequisicaoDto;
import com.example.biblioteca.Dto.EmprestimoRespostaDto;
import com.example.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {
    public Emprestimo paraEntidade(
            EmprestimoRequisicaoDto emprestimoRequisicaoDto){
        return new Emprestimo(
                emprestimoRequisicaoDto.livro_id(),
                emprestimoRequisicaoDto.usuario_id(),
                emprestimoRequisicaoDto.data_emprestimo(),
                emprestimoRequisicaoDto.data_devolucao()
        );
    }
    public EmprestimoRespostaDto paraRespostaDto(
            Emprestimo emprestimo
    ){
        return new EmprestimoRespostaDto(
                emprestimo.getId(),
                emprestimo.getLivro_id(),
                emprestimo.getUsuario_id(),
                emprestimo.getData_emprestimo(),
                emprestimo.getData_devolucao()
        );
    }
}
