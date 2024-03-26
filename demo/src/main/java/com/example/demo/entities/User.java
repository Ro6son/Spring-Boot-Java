package com.example.demo.entities;

import java.io.Serializable; // Importa a interface Serializable, que marca uma classe como serializável, permitindo que objetos dessa classe sejam convertidos em uma sequência de bytes para serem armazenados em arquivos ou transmitidos pela rede
import java.util.Objects; // importa a classe Objects do pacote java.util, que fornece métodos utilitários para operações comuns em objetos, como checagem de nulos, comparação de objetos e geração de hash

import jakarta.persistence.Entity; // Importa a anotação Entity do pacote jakarta.persistence, que é usada para marcar uma classe como uma entidade JPA, mapeando-a para uma tabela no banco de dados
import jakarta.persistence.GeneratedValue; // Importa a anotação GeneratedValue do pacote jakarta.persistence, que é usada para especificar a estratégia de geração de valores para chaves primárias das entidades JPA
import jakarta.persistence.GenerationType; //Importa a enumeração GenerationType do pacote jakarta.persistence, que define diferentes estratégias de geração de chaves primárias para entidades JPA
import jakarta.persistence.Id; // Importa a anotação Id do pacote jakarta.persistence, que é usada para marcar um campo como a chave primária da entidade JPA
import jakarta.persistence.Table; //Importa a anotação Table do pacote jakarta.persistence, que é usada para especificar o nome da tabela no banco de dados à qual a entidade JPA está mapeada

@Entity // Annotation para indicar que essa classe é uma entidade JPA
@Table(name = "tb_user") // Annotation para especificar o nome da tabela no banco de dados
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Annotation para indicar que esse atributo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation para indicar que o valor será gerado automaticamente pelo banco de dados
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String password;

    // Construtor vazio
    public User() {
    }

    // Construtor com todos os atributos
    public User(Long id, String nome, String email, String telefone, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.password = password;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Implementação do método hashCode() para calcular o hash do objeto
    // anotação @Override é usada para indicar que os métodos hashCode() e equals() estão substituindo métodos da superclasse Object
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Implementação do método equals() para comparar objetos
    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(id, user.id);
    }
}
