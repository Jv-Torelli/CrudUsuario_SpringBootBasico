package com.example.crud.repository;

// 4. REPOSITORY
// O Repository serve para acessar o banco de dados.
// Ele estende JpaRepository que já fornece métodos prontos como:
// save(), findById(), findAll(), deleteById(), etc.
// Você pode adicionar métodos customizados usando convenções de nomenclatura.

import com.example.crud.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository // Indica que esta interface é um repositório Spring
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Spring Data JPA cria a implementação automaticamente baseado no nome do metodo
    Optional<Usuario> findByEmail(String email);

    // Verifica se existe um usuário com determinado email
    boolean existsByEmail(String email);
}
