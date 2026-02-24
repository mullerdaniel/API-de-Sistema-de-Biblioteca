package com.example.biblioteca.mapper;

import com.example.biblioteca.Dto.UsuarioRequisicaoDto;
import com.example.biblioteca.Dto.UsuarioRespostaDto;
import com.example.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario paraEntidade(
            UsuarioRequisicaoDto usuarioRequisicaoDto) {
        return new Usuario(
                usuarioRequisicaoDto.nome(),
                usuarioRequisicaoDto.email()
        );
    }
    public UsuarioRespostaDto paraRespostaDto(
            Usuario usuario
    ){
        return new UsuarioRespostaDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
