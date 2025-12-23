package com.example.crud.dto;

// DTO DE RESPONSE (Saída de dados)
// Usado quando a API retorna dados para o CLIENTE
// Contém ID pois estamos retornando um usuário já salvo no banco

public record UsuarioResponseDTO(
        String nome,
        String email,
        Integer idade
) {
    // O record já cria tudo automaticamente!
    // Acesso: responseDTO.id(), responseDTO.nome(), etc.
}

