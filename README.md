# CRUD de Usuários com Spring Boot (Projeto Didático)

## 📌 Sobre o Projeto

Este projeto é um **CRUD simples de cadastro de usuários**, desenvolvido com **Spring Boot**, utilizando **H2 Database**, com foco **educacional**.

O principal objetivo é servir como um **pontapé inicial para os estudos em Spring Boot**, apresentando de forma clara e comentada:
- A arquitetura em camadas
- O fluxo de uma requisição REST
- O uso de DTOs, Mapper e tratamento global de exceções
- O papel de cada anotação e classe do Spring

Todo o código contém **comentários didáticos**, explicando o *porquê* e *para que* cada parte existe.

---

## 🎯 Objetivo Educacional

Este projeto foi criado para ajudar quem está:
- Iniciando com Spring Boot
- Aprendendo APIs REST
- Entendendo boas práticas de organização
- Estudando separação de responsabilidades
- Aprendendo a lidar com erros de forma centralizada

Ele serve como **base sólida** para projetos mais complexos no futuro.

---

## ⚙️ Funcionalidades

- ✅ Criar usuário
- 📄 Listar todos os usuários
- 🔍 Buscar usuário por ID
- ✏️ Atualizar usuário
- ❌ Deletar usuário
- 🚨 Tratamento global de exceções
- 🧪 Banco em memória com H2

---

## 🧱 Arquitetura do Projeto

O projeto segue uma **arquitetura em camadas**, separando claramente as responsabilidades:


Cada camada tem uma função bem definida.

---

## 📁 Estrutura de Pastas

```bash
src/main/java/com/example/crud
│
├── controller
│   └── UsuarioController        # Recebe requisições HTTP
│
├── dto
│   ├── UsuarioRequestDTO        # Dados de entrada
│   ├── UsuarioResponseDTO       # Dados de saída
│   └── mapper
│       └── UsuarioMapper        # Conversão entre DTO e Entity
│
├── entity
│   └── Usuario                  # Entidade JPA
│
├── exception
│   └── GlobalExceptionHandler   # Tratamento global de erros
│
├── repository
│   └── UsuarioRepository        # Acesso ao banco de dados
│
├── service
│   └── UsuarioService           # Regras de negócio
│
└── CrudApplication              # Classe principal do Spring Boot utilizada para fazer o build do projeto localmente
