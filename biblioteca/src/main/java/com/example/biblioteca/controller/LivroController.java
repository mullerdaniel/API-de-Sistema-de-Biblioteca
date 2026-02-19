package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/biblioteca")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }


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
}
