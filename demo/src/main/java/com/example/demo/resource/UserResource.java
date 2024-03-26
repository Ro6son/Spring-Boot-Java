package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação @Autowired para injeção de dependência
import org.springframework.http.HttpStatus; // Importa a classe HttpStatus para definição de códigos de status HTTP
import org.springframework.http.ResponseEntity; // Importa a classe ResponseEntity para encapsular a resposta HTTP
import org.springframework.web.bind.annotation.DeleteMapping; // Importa a anotação DeleteMapping para mapear requisições DELETE
import org.springframework.web.bind.annotation.GetMapping; // Importa a anotação GetMapping para mapear requisições GET
import org.springframework.web.bind.annotation.PathVariable; // Importa a anotação PathVariable para mapear variáveis de path
import org.springframework.web.bind.annotation.PostMapping; // Importa a anotação PostMapping para mapear requisições POST
import org.springframework.web.bind.annotation.PutMapping; // Importa a anotação PutMapping para mapear requisições PUT
import org.springframework.web.bind.annotation.RequestBody; // Importa a anotação RequestBody para mapear o corpo da requisição
import org.springframework.web.bind.annotation.RequestMapping; // Importa a anotação RequestMapping para mapear o caminho da requisição
import org.springframework.web.bind.annotation.RestController; // Importa a anotação RestController para indicar que a classe é um controlador REST

import com.example.demo.entities.User; // Importa a classe User do pacote entities
import com.example.demo.services.UserService; // Importa a interface UserService do pacote services

@RestController 
@RequestMapping(value = "/users") // Define o caminho base para todas as rotas definidas nesta classe como "/users"
public class UserResource {

    // Injeção do serviço de usuário
    @Autowired // Indica ao Spring que esta instância será injetada automaticamente
    private UserService userService; // Declaração da instância do serviço de usuário

    // Rota para listar todos os usuários (GET)
    @GetMapping // Mapeia uma requisição GET
    public ResponseEntity<List<User>> findAll() { // Método para listar todos os usuários
        List<User> users = userService.findAll(); // Chama o método findAll do serviço de usuário para obter todos os usuários
        return ResponseEntity.ok().body(users); // Retorna uma resposta HTTP com a lista de usuários e o código de status OK (200)
    }

    // Rota para buscar um usuário por ID (GET)
    @GetMapping(value = "/{id}") // Mapeia uma requisição GET com um ID na URL
    public ResponseEntity<User> findById(@PathVariable Long id) { // Método para buscar um usuário por ID
        User user = userService.findById(id); // Chama o método findById do serviço de usuário para obter o usuário com o ID fornecido
        return ResponseEntity.ok().body(user); // Retorna uma resposta HTTP com o usuário encontrado e o código de status OK (200)
    }

    // Rota para inserir um novo usuário (POST)
    @PostMapping // Mapeia uma requisição POST
    public ResponseEntity<User> insert(@RequestBody User user) { // Método para inserir um novo usuário recebendo um corpo JSON
        User newUser = userService.insert(user); // Chama o método insert do serviço de usuário para inserir o novo usuário
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser); // Retorna uma resposta HTTP com o novo usuário inserido e o código de status CREATED (201)
    }

    // Rota para deletar um usuário por ID (DELETE)
    @DeleteMapping(value = "/{id}") // Mapeia uma requisição DELETE com um ID na URL
    public ResponseEntity<Void> delete(@PathVariable Long id) { // Método para deletar um usuário por ID
        userService.delete(id); // Chama o método delete do serviço de usuário para deletar o usuário com o ID fornecido
        return ResponseEntity.noContent().build(); // Retorna uma resposta HTTP sem conteúdo e o código de status NO_CONTENT (204)
    }

    // Rota para atualizar um usuário (PUT)
    @PutMapping(value = "/{id}") // Mapeia uma requisição PUT com um ID na URL
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) { // Método para atualizar um usuário recebendo um corpo JSON
        User updatedUser = userService.update(id, user); // Chama o método update do serviço de usuário para atualizar o usuário com o ID fornecido
        return ResponseEntity.ok().body(updatedUser); // Retorna uma resposta HTTP com o usuário atualizado e o código de status OK (200)
    }
}
