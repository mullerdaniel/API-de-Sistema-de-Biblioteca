package com.example.biblioteca.controller;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }


    // METODO POST
    @PostMapping
    public Emprestimo salvarEmprestimo(
            @RequestBody Emprestimo emprestimo
    ){
        try {
            return emprestimoService.salvarEmprestimo(emprestimo);

        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }












}
