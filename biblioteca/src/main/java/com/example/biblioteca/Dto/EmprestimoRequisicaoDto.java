package com.example.biblioteca.Dto;

import java.time.LocalDate;

public record EmprestimoRequisicaoDto (
    int livro_id,
    int usuario_id,
    LocalDate data_emprestimo,
    LocalDate data_devolucao
 ){
}
