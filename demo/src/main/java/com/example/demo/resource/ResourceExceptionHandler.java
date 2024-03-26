package com.example.demo.resource;

import java.time.Instant; // Importa a classe Instant, que representa um ponto específico no tempo.

import org.springframework.http.HttpStatus; // Importa a classe HttpStatus do Spring, que representa um código de status HTTP.
import org.springframework.http.ResponseEntity; // Importa a classe ResponseEntity do Spring, que representa toda a resposta HTTP, incluindo cabeçalhos, status e corpo.
import org.springframework.web.bind.annotation.ControllerAdvice; // Importa a anotação ControllerAdvice do Spring, que indica que a classe é responsável por tratar exceções globais em todos os controllers.
import org.springframework.web.bind.annotation.ExceptionHandler; // Importa a anotação ExceptionHandler do Spring, que indica que o método trata exceções específicas.
import org.springframework.web.context.request.WebRequest; // Importa a classe WebRequest do Spring, que fornece informações sobre a solicitação HTTP atual.

import com.example.demo.resource.exceptions.StandardError; // Importa a classe StandardError
import com.example.demo.services.exceptions.ResourceNotFoundException; // Importa a exceção ResourceNotFoundException

@ControllerAdvice // Anotação que define uma classe de tratamento de exceções global
public class ResourceExceptionHandler {

	// Método para lidar com exceções ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class) // Anotação para indicar que este método trata exceções do tipo
														// ResourceNotFoundException
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND; // Define o status da resposta como NOT_FOUND (404)
		// Cria um objeto StandardError contendo informações sobre o erro
		StandardError err = new StandardError(Instant.now(), status.value(), "Not found", e.getMessage(),
				request.getDescription(false));
		// Retorna uma resposta com o status e o corpo contendo o objeto StandardError
		return ResponseEntity.status(status).body(err);
	}
}
