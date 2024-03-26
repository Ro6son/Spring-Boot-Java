package com.example.demo.services.exceptions;

import java.io.Serializable;

// Esta classe representa uma exceção personalizada que é lançada quando um recurso não é encontrado
public class ResourceNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L; // Identificador de serialização para garantir consistência

	// Construtor que recebe uma mensagem personalizada para a exceção
	public ResourceNotFoundException(String message) {
		// Chama o construtor da classe pai (RuntimeException) com a mensagem fornecida
		super(message);
	}
}
