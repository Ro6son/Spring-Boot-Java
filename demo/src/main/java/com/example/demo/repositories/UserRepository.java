package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface responsável por acessar os dados da entidade User
// Estende JpaRepository que fornece operações CRUD básicas para a entidade User
public interface UserRepository extends JpaRepository<User, Long> {
	// Nenhuma implementação adicional é necessária aqui, pois o JpaRepository já
	// fornece todos os métodos necessários
	// A definição da interface já permite que Spring Data JPA gere automaticamente
	// as implementações dos métodos CRUD
	// e outros métodos de consulta com base nos nomes dos métodos definidos nesta
	// interface
}
