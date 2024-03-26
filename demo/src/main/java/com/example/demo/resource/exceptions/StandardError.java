package com.example.demo.resource.exceptions; // Pacote onde está localizada a classe StandardError

import java.io.Serializable; // Importa a interface Serializable, usada para serialização de objetos
import java.time.Instant; // Importa a classe Instant do Java.time, que representa um ponto específico no tempo
import java.util.Objects; // Importa a classe Objects do Java.util, usada para manipulação de objetos

// Esta classe representa um objeto de erro padrão a ser retornado em caso de exceção
public class StandardError implements Serializable { // Declaração da classe StandardError, que implementa Serializable

	private static final long serialVersionUID = 1L; // Identificador de serialização para garantir consistência

	private Instant timestamp; // Declaração do atributo timestamp do tipo Instant, representa o momento em que o erro ocorreu
	private Integer status; // Declaração do atributo status do tipo Integer, representa o código de status HTTP do erro
	private String error; // Declaração do atributo error do tipo String, representa o tipo de erro
	private String message; // Declaração do atributo message do tipo String, representa a mensagem de erro
	private String path; // Declaração do atributo path do tipo String, representa o caminho onde o erro ocorreu

	public StandardError() {
		// Construtor vazio
	}

	// Construtor com todos os atributos
	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	// Getters e Setters para os atributos

	public Instant getTimestamp() { // Método getter para o atributo timestamp
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) { // Método setter para o atributo timestamp
		this.timestamp = timestamp;
	}

	public Integer getStatus() { // Método getter para o atributo status
		return status;
	}

	public void setStatus(Integer status) { // Método setter para o atributo status
		this.status = status;
	}

	public String getError() { // Método getter para o atributo error
		return error;
	}

	public void setError(String error) { // Método setter para o atributo error
		this.error = error;
	}

	public String getMessage() { // Método getter para o atributo message
		return message;
	}

	public void setMessage(String message) { // Método setter para o atributo message
		this.message = message;
	}

	public String getPath() { // Método getter para o atributo path
		return path;
	}

	public void setPath(String path) { // Método setter para o atributo path
		this.path = path;
	}

	// Sobrescrita dos métodos equals e hashCode para garantir consistência na comparação de objetos
	@Override
	public int hashCode() { // Sobrescrita do método hashCode para calcular o hash do objeto
		return Objects.hash(timestamp, status, error, message, path);
	}

	@Override
	public boolean equals(Object o) { // Sobrescrita do método equals para comparar objetos
		if (this == o) // Verifica se os objetos são iguais (mesma referência)
			return true;
		if (o == null || getClass() != o.getClass()) // Verifica se o objeto passado é nulo ou se é de uma classe diferente
			return false;
		StandardError that = (StandardError) o; // Faz o casting do objeto para a classe StandardError
		return Objects.equals(timestamp, that.timestamp) && Objects.equals(status, that.status) // Compara os atributos dos objetos
				&& Objects.equals(error, that.error) && Objects.equals(message, that.message)
				&& Objects.equals(path, that.path);
	}
}
