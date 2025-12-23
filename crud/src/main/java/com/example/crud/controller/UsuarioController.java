package com.example.crud.controller;

// CONTROLLER
// O Controller serve para receber requisições HTTP e devolver respostas.
// Ele é a porta de entrada da aplicação (camada de apresentação).
// Recebe dados do cliente, chama o Service e retorna a resposta.

import com.example.crud.dto.UsuarioRequestDTO;
import com.example.crud.dto.UsuarioResponseDTO;
import com.example.crud.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Indica que esta classe é um controller REST
@RequestMapping("/api/usuarios") // Define o caminho base para todas as rotas
public class UsuarioController {

    // @Autowired injeta automaticamente o UsuarioService
    @Autowired
    private UsuarioService service;

    // POST /api/usuarios - Criar novo usuário
    @PostMapping
    //ResponseEntity serve para retornar um DTO de resposta
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioRequestDTO requestDTO) {
        // @Valid ativa as validações do DTO
        // @RequestBody indica que os dados vêm no corpo da requisição em JSON
        UsuarioResponseDTO criado = service.criar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    // GET /api/usuarios - Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        List<UsuarioResponseDTO> usuarios = service.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // GET /api/usuarios/{id} - Buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        // @PathVariable captura o {id} da URL
        UsuarioResponseDTO usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // PUT /api/usuarios/{id} - Atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO requestDTO) {
        UsuarioResponseDTO atualizado = service.atualizar(id, requestDTO);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE /api/usuarios/{id} - Deletar usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
