# Spring Boot Java Demo 🤖👽

Este é um projeto de demonstração que ilustra o desenvolvimento de uma aplicação utilizando Spring Boot com Java. O projeto inclui diversas classes e componentes que demonstram conceitos fundamentais do Spring Boot, como controle de exceções, injeção de dependência, mapeamento de entidades JPA, e criação de serviços RESTful.

## Visão Geral do Projeto 🎯

O projeto consiste nos seguintes pacotes e classes:

- **entities**: Contém a definição da entidade `User`, que representa um usuário da aplicação.
- **repositories**: Contém a interface `UserRepository`, responsável por acessar os dados da entidade `User` no banco de dados.
- **services**: Contém a interface `UserService`, que define operações relacionadas aos usuários, e a implementação `UserServiceImpl`, que oferece serviços para gerenciar usuários.
- **services.exceptions**: Contém a exceção `ResourceNotFoundException`, que é lançada quando um recurso não é encontrado.
- **resource**: Contém os controladores RESTful que expõem endpoints para manipulação dos usuários.
- **resource.exceptions**: Contém o controlador de exceções `ResourceExceptionHandler`, responsável por tratar exceções globais na aplicação.
- **DemoApplication**: Classe principal que inicia a aplicação Spring Boot.

## 📌 Objetivos & Endpoints:
- Criar projeto Spring Boot Java
- Implementar modelo de domínio
- Estruturar camadas lógicas: resource, service, repository
- Configurar banco de dados de teste (H2)
- Povoar o banco de dados
- CRUD - Create, Retrieve, Update, Delete
- Tratamento de exceções
- findAll (GET)
- findById (GET)
- insert (POST)
- delete (DELETE)
- update (PUT)

## 📌 Checklist
- Utilização de um editor de código sugerido neste documento;
- Instalação do Postman e do Git (opcional);
- Criação do projeto base;
- Adição das dependências e implementação das properties.
- Implementação das classes: User, UserResource e UserService.
- Implementação da interface UserRepository.
- Implementação das classes e mecanismo de exceção.
- Configuração da aplicação para testes.
- Teste da aplicação com a ferramenta postman.


## 📌 Funcionalidades Principais

- Listagem de todos os usuários cadastrados.
- Busca de um usuário por ID.
- Inserção de um novo usuário.
- Atualização de um usuário existente.
- Remoção de um usuário pelo ID.

## 📌Resultado:
Uma pasta com arquivos que contenha a estrutura do projeto como informado na descrição da atividade, ou seja, os seguintes arquivos com extensão java: User, UserResource, UserService, UserRepository, ResourceExceptionHandler, StandardError, ResourceNotFoundException e TestConfig.

## ▶️ Como Executar

Para executar o projeto localmente, siga estas etapas:

1. Certifique-se de ter o Java JDK e o Maven instalados em sua máquina.
2. Clone este repositório.
3. Navegue até o diretório raiz do projeto.
4. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.
5. Acesse os endpoints fornecidos pelos controladores RESTful através de um cliente HTTP, como o Postman.

## 📍 Contribuições

Contribuições são bem-vindas! Se você identificar melhorias ou correções no código, fique à vontade para enviar um pull request.

## 📍 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
