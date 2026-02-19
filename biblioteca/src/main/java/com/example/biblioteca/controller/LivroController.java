package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }


    // METODO POST
    @PostMapping
    public Livro salvarLivro(
            @RequestBody Livro livro
    ){
        try {
            return livroService.salvarLivro(livro);

        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    // METODO GET
    @GetMapping
    public List<Livro> listarLivro() throws SQLException {
        try {
            return livroService.listarLivro();

        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    // METODO GET POR ID
    @GetMapping("/{id}")
    public Livro listarLivroPorId(
            @PathVariable int id
    ){
        try{
            return livroService.buscarLivroPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    // METODO DELETE
    @DeleteMapping("/{id}")
    public void deletarLivro(
            @PathVariable int id
    ){
        try{
            livroService.deletarLivroPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    // METODO PUT = ATUALIZAR
    @PutMapping("/{id}")
    public Livro atualizarLivro(
            @PathVariable int id,
            @RequestBody Livro livro
    ){
        try{
            return livroService.atualizarLivro(livro, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
