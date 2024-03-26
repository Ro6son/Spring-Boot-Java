package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;

@Service // Adiciona a anotação @Service para indicar que esta interface é um serviço
public interface UserService {

    // Método para buscar todos os usuários
    List<User> findAll();

    // Método para buscar um usuário por ID
    User findById(Long id) throws ResourceNotFoundException; // Adiciona a exceção ResourceNotFoundException na assinatura do método

    // Método para inserir um novo usuário
    User insert(User user);

    // Método para deletar um usuário por ID
    void delete(Long id) throws ResourceNotFoundException; // Adiciona a exceção ResourceNotFoundException na assinatura do método

    // Método para atualizar um usuário
    User update(Long id, User user) throws ResourceNotFoundException; // Adiciona a exceção ResourceNotFoundException na assinatura do método

    // Método para obter o repositório de usuários
    UserRepository getUserRepository();
}
