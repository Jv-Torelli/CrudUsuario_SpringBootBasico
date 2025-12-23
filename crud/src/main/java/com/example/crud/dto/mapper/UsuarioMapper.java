package com.example.crud.dto.mapper;

// MAPPER
// O Mapper serve para converter entre Entity e DTO.
// Isso mantém as camadas desacopladas e facilita manutenção.
// Evita que a estrutura do banco de dados seja exposta diretamente.

import com.example.crud.dto.UsuarioRequestDTO;
import com.example.crud.dto.UsuarioResponseDTO;
import com.example.crud.entity.Usuario;
import org.springframework.stereotype.Component;

@Component // Indica que esta classe é um componente Spring gerenciado
public class UsuarioMapper {

    // Converte de Entity para ResponseDTO (quando enviamos dados ao cliente)
    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        return new UsuarioResponseDTO(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getIdade()
        );
    }

    // Converte de RequestDTO para Entity (quando recebemos dados do cliente para CRIAR)
    public Usuario toEntity(UsuarioRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setIdade(requestDTO.idade());
        // Não seta ID pois será gerado pelo banco
        return usuario;
    }

    // Atualiza uma Entity existente com dados do RequestDTO (para ATUALIZAR)
    public void updateEntity(Usuario usuario, UsuarioRequestDTO requestDTO) {
        if (usuario == null || requestDTO == null) {
            return;
        }

        usuario.setNome(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setIdade(requestDTO.idade());
        // Não atualiza o ID pois ele não deve mudar
    }
}
