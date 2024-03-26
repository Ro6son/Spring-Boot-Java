package com.example.demo.services.userServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação @Autowired
import org.springframework.dao.EmptyResultDataAccessException; // Importa a exceção EmptyResultDataAccessException
import org.springframework.stereotype.Service; // Importa a anotação @Service

import com.example.demo.entities.User; // Importa a classe User
import com.example.demo.repositories.UserRepository; // Importa a interface UserRepository
import com.example.demo.services.UserService; // Importa a interface UserService
import com.example.demo.services.exceptions.ResourceNotFoundException; // Importa a exceção ResourceNotFoundException

@Service // Indica que a classe é um componente de serviço gerenciado pelo Spring
public class UserServiceImpl implements UserService { // Implementa a interface UserService

    @Autowired // Injeta o repositório de usuários nesta classe
    private UserRepository userRepository;

    // Método para buscar todos os usuários
    @Override
    public List<User> findAll() {
        return userRepository.findAll(); // Retorna todos os usuários do repositório
    }

    // Método para buscar um usuário por ID
    @Override
    public User findById(Long id) {
        return userRepository.findById(id) // Busca o usuário pelo ID no repositório
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id)); // Lança uma exceção se o usuário não for encontrado
    }

    // Método para inserir um novo usuário
    @Override
    public User insert(User user) {
        return userRepository.save(user); // Insere o usuário no repositório
    }

    // Método para deletar um usuário por ID
    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id); // Deleta o usuário pelo ID do repositório
        } catch (EmptyResultDataAccessException e) { // Captura uma exceção se o usuário não for encontrado
            throw new ResourceNotFoundException("User not found: " + id); // Lança uma exceção personalizada
        }
    }

    // Método para atualizar um usuário
    @Override
    public User update(Long id, User user) {
        User entity = userRepository.findById(id) // Busca o usuário pelo ID no repositório
                                    .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id)); // Lança uma exceção se o usuário não for encontrado
        updateData(entity, user); // Atualiza os dados do usuário
        return userRepository.save(entity); // Salva as alterações no repositório
    }

    // Método utilitário para atualizar os dados do usuário
    private void updateData(User entity, User user) {
        entity.setNome(user.getNome()); // Atualiza o nome do usuário
        entity.setEmail(user.getEmail()); // Atualiza o email do usuário
        entity.setTelefone(user.getTelefone()); // Atualiza o telefone do usuário
        entity.setPassword(user.getPassword()); // Atualiza a senha do usuário
    }

    // Método para obter o repositório de usuários
    @Override
    public UserRepository getUserRepository() {
        return userRepository; // Retorna o repositório de usuários
    }
}
