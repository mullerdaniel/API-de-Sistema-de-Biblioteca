package com.example.biblioteca.controller;

import com.example.biblioteca.model.Emprestimo;
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



    @PostMapping
    public Emprestimo salvarEmprestimo(@RequestBody Emprestimo emprestimo) {
        try {
            return emprestimoService.salvarEmprestimo(emprestimo);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    @GetMapping
    public List<Emprestimo> listarEmprestimo() {
        try {
            return emprestimoService.listarEmprestimo();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Emprestimo listarEmprestimoPorId(@PathVariable int id) {
        try {
            return emprestimoService.buscarEmprestimoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public void deletarEmprestimo(@PathVariable int id) {
        try {
            emprestimoService.deletarEmprestimoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    @PutMapping("/{id}")
    public Emprestimo atualizarEmprestimo(@PathVariable int id, @RequestBody Emprestimo emprestimo) {
        try {
            return emprestimoService.atualizarEmprestimo(emprestimo, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
