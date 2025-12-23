package com.example.crud.service;

// SERVICE
// A Service serve para conter a lógica de negócio da aplicação.
// Ela fica entre o Controller e o Repository.
// Aqui ficam as regras de negócio, validações complexas e orquestração de operações.

import com.example.crud.dto.UsuarioRequestDTO;
import com.example.crud.dto.UsuarioResponseDTO;
import com.example.crud.dto.mapper.UsuarioMapper;
import com.example.crud.entity.Usuario;
import com.example.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service // Indica que esta classe é um serviço Spring
public class UsuarioService {

    // @Autowired faz a injeção automática de dependências pelo Spring
    // O Spring procura um bean do tipo UsuarioRepository e injeta automaticamente
    @Autowired
    private UsuarioRepository repository;

    // Injeta o mapper para fazer conversões entre Entity e DTO
    @Autowired
    private UsuarioMapper mapper;

    // CREATE - Criar novo usuário
    @Transactional // Garante que a operação seja atômica (tudo ou nada)
    public UsuarioResponseDTO criar(UsuarioRequestDTO requestDTO) {
        // Validação de negócio: verifica se email já existe
        if (repository.existsByEmail(requestDTO.email())) {
            throw new RuntimeException("Email já cadastrado: " + requestDTO.email());
        }

        // Converte RequestDTO para Entity
        Usuario usuario = mapper.toEntity(requestDTO);

        // Salva no banco de dados
        Usuario salvo = repository.save(usuario);

        // Converte Entity para ResponseDTO e retorna
        return mapper.toResponseDTO(salvo);
    }

    // READ - Buscar todos os usuários
    @Transactional(readOnly = true) // readOnly otimiza leitura
    public List<UsuarioResponseDTO> listarTodos() {
        return repository.findAll()
                .stream() // Transforma lista em stream
                .map(mapper::toResponseDTO) // Converte cada Entity para ResponseDTO
                .collect(Collectors.toList()); // Coleta resultado em lista
    }

    // READ - Buscar usuário por ID
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));

        return mapper.toResponseDTO(usuario);
    }

    // UPDATE - Atualizar usuário existente
    @Transactional
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO requestDTO) {
        // Busca usuário existente
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));

        // Verifica se o email já está sendo usado por outro usuário
        if (!usuario.getEmail().equals(requestDTO.email()) &&
                repository.existsByEmail(requestDTO.email())) {
            throw new RuntimeException("Email já cadastrado: " + requestDTO.email());
        }

        // Atualiza os campos da entidade com dados do RequestDTO
        mapper.updateEntity(usuario, requestDTO);

        // Salva as alterações
        Usuario atualizado = repository.save(usuario);

        return mapper.toResponseDTO(atualizado);
    }

    // DELETE - Deletar usuário
    @Transactional
    public void deletar(Long id) {
        // Verifica se usuário existe
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }

        // Deleta o usuário
        repository.deleteById(id);
    }
}
