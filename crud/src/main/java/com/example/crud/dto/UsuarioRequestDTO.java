package com.example.crud.dto;

// DTOs (Data Transfer Object)
// O DTO serve para transferir dados entre camadas da aplicação.
// Ele protege a entidade, evitando expor dados sensíveis ou estrutura do banco.
// RECORD: É uma classe especial do Java (desde Java 14) que:
// - Cria automaticamente getters (sem o "get", apenas o nome do campo)
// - Cria automaticamente equals(), hashCode() e toString()
// - Cria construtor com todos os parâmetros
// - Os campos são final (imutáveis) por padrão
// - Código muito mais limpo e conciso!

import jakarta.validation.constraints.*;

// DTO DE REQUEST (Entrada de dados)
// Usado quando o CLIENTE envia dados para a API (criar/atualizar)
// Não contém ID pois o ID é gerado pelo banco ao criar

public record UsuarioRequestDTO(

        @NotBlank(message = "Nome é obrigatório") // Validação: não pode ser vazio
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email deve ser válido")
        String email,

        @NotNull(message = "Idade é obrigatória")
        @Min(value = 18, message = "Idade mínima é 18 anos")
        @Max(value = 120, message = "Idade máxima é 120 anos")
        Integer idade
) {
    // O record já cria:
    // - Construtor: new UsuarioRequestDTO(nome, email, idade)
    // - Getters: requestDTO.nome(), requestDTO.email(), requestDTO.idade()
    // - equals(), hashCode(), toString()
    // Não precisa escrever nada aqui!
}

