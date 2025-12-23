package com.example.crud.entity;

// 1. ENTIDADE (Entity)
// A Entity representa a tabela no banco de dados.
// Cada atributo da classe será uma coluna na tabela.
// As anotações JPA (@Entity, @Table, @Id, etc) fazem o mapeamento objeto-relacional.

import jakarta.persistence.*;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "usuarios") // Define o nome da tabela no banco
public class Usuario {

    @Id // Define este campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private Long id;

    @Column(nullable = false, length = 100) // Configurações da coluna
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private Integer idade;

    // Construtor vazio (obrigatório para JPA)
    public Usuario() {
    }

    // Construtor com todos os campos
    public Usuario(Long id, String nome, String email, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}