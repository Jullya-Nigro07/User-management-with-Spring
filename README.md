# 🍃 User management with Spring
Sistema de gerenciamento de usuários desenvolvido com Java 21 e Spring Boot, seguindo boas práticas de arquitetura, separação de responsabilidades e documentação com OpenAPI (Swagger)

![Status](https://img.shields.io/badge/Status-Em%20Andamento-yellow)

> 📝 **Nota:** Esse projeto foi desenvolvido durante a minha formação do curso da DIO - "Backend com Java & AWS", e foi aprimorado com base nos meus conhecimentos :)

---

🛠️ Tecnologias Utilizadas

![Linguagem](https://img.shields.io/badge/Linguagem-Java%2021-red)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-purple)
![Framework](https://img.shields.io/badge/Framework-Spring%20Boot-darkgreen)
![Banco de Dados](https://img.shields.io/badge/Banco%20de%20Dados-PostgreSQL-blue)

---

### ⚙️ Desenvolvimento do Projeto

O User Management with Spring é uma API REST para gerenciamento de usuários, desenvolvida com base em um MVC estendido, utilizando Spring Boot, Spring Data JPA e PostgreSQL.

**O objetivo do projeto é:**

   - Praticar a criação de APIs REST em Java
   - Aplicar boas práticas de organização por camadas
   - Utilizar DTOs para proteger dados sensíveis
   - Implementar tratamento global de exceções
   - Documentar a API com Swagger / OpenAPI

---

🌱 Starters Utilizados

![Starter](https://img.shields.io/badge/Starter-Spring%20Data%20JPA-brightgreen?style=for-the-badge)
![Starter](https://img.shields.io/badge/Starter-Spring%20Web-brightgreen?style=for-the-badge)
![Starter](https://img.shields.io/badge/Starter-Spring%20OpenAPI-brightgreen?style=for-the-badge)
![Starter](https://img.shields.io/badge/Starter-PostgreSQL-brightgreen?style=for-the-badge)

---

### 📁 Estrutura do projeto


        src/
        └── main/
           └── java/
             └── dio.web.api/
                ├── config/     
                │     └── OpenApiConfig.java
                │
                ├── controller/
                │     └── doc/
                │          └── UserControllerDoc.java
                │     └──  UserController.java
                │
                ├── dto/
                │      ├── UserCreateDTO.java
                │      └──  UserUpdateDTO.java
                │    
                ├── handler/
                │      ├── BusinessException.java
                │      ├── GlobalExceptionHandler.java
                │      └── ResourceNotFoundException.java
                │   
                ├── model/
                │      └── User.java
                │  
                ├── repositoty/
                │      └── UserRepository.java
                │
                ├── service/
                │      └── UserService.java
                │
                └── Main.java

---

### ✅ Funcionalidades

- CRUD de Usuários


  - POST - Criar um novo usuário
  - PATCH/{id} - Atualizar um usuário existente
  - GET - Listar todos os usuários
  - GET/{id} - Buscar usuário por id
  - DELETE/{id} - Remover usuário


- Tratementos global de erros


   - Implementado com @ControllerAdvice e @ExceptionHandler


- DTOs


   - Proteção de dados sensíveis (ex: ID e senha)


- Documentação da API


   - Utilização de @Operation e @ApiResponse com OpenAPI 3

---

## 🚀 Como Rodar o Projeto

1. **Clone o repositório:**

   ```bash
   git clone "https://github.com/Jullya-Nigro07/User-management-with-Spring.git"
    ```

2. **Configure o PostgreSQL**


   - Utilize o PostgreSQL versão 18
   - Crie um banco de dados com o nome de sua preferência:

   ```sql
   CREATE DATABASE my_users;
   ```

3. **Abra o projeto na IDE**


   - Abra no IntelliJ IDEA (ou outra IDE compatível com Java 21)


4. **Configure o banco de dados**


   - No arquivo application.properties (ou application.yml), ajuste as credenciais:


   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_DO_BANCO
   spring.datasource.username=postgres
   spring.datasource.password=SUA_SENHA
   ```

5. **Execute a aplicação**


   - Rode a classe principal Main
   - Aguarde o build finalizar


6. **Acesse a documentação Swagger**


  ```text
    http://localhost:8080/swagger-ui/index.html
  ```

7. Consultar tabelas no PostgreSQL

   ```sql
   SELECT * FROM users;
   
   ```
   
---

