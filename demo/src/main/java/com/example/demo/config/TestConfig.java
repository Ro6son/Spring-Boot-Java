package com.example.demo.config;

import java.util.Arrays; // Importa a classe Arrays para manipular arrays

import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação @Autowired para injeção de dependência
import org.springframework.boot.CommandLineRunner; // Importa a interface CommandLineRunner para execução de tarefas durante a inicialização da aplicação
import org.springframework.context.annotation.Configuration; // Importa a anotação @Configuration para indicar que esta classe é uma configuração do Spring

import com.example.demo.entities.User; // Importa a classe User do pacote entities
import com.example.demo.repositories.UserRepository; // Importa a interface UserRepository do pacote repositories

@Configuration // Indica que esta classe é uma classe de configuração do Spring
public class TestConfig implements CommandLineRunner { // Implementa a interface CommandLineRunner para executar a lógica durante a inicialização da aplicação

    @Autowired // Injeta uma instância de UserRepository nesta classe
    private UserRepository userRepository; // Repositório para operações relacionadas à entidade User

    @Override // Indica que este método está sobrescrevendo um método da classe pai
    public void run(String... args) throws Exception { // Método a ser executado durante a inicialização da aplicação
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); // Cria um novo objeto User 1
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); // Cria um novo objeto User 2
        userRepository.saveAll(Arrays.asList(u1, u2)); // Salva os objetos User no banco de dados usando o método saveAll do UserRepository
    }
}
