# Products API

## Descrição

Esta é uma API simples de gerenciamento de produtos desenvolvida com **Spring Boot** e **JPA**. Ela permite criar, listar, atualizar e deletar produtos. A API utiliza **PostgreSQL** como banco de dados e inclui suporte ao **Lombok** para a redução de boilerplate de código.

## Requisitos

- **Java 22**
- **Maven**
- **PostgreSQL**
- **Spring Boot 3.3.3**

## Configuração do Banco de Dados

1. Certifique-se de que o PostgreSQL está rodando em sua máquina.
2. Crie um banco de dados com o nome desejado.
3. Atualize o arquivo `application.properties` com suas credenciais do banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seubancodedados
spring.datasource.username=seuusuario
spring.datasource.password=suasenha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Compilação e Execução

Para compilar e executar o projeto, utilize os seguintes comandos no terminal:

```bash
# Para compilar o projeto
mvn clean install

# Para rodar a aplicação
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`.

## Endpoints da API

### 1. Adicionar um Produto

**URL:** `/api/products/add`  
**Método:** `POST`  
**Descrição:** Adiciona um novo produto.  
**Exemplo de Payload (JSON):**

```json
{
  "productName": "Smartphone",
  "supplier": "Samsung",
  "imageUrl": "https://example.com/image.jpg",
  "price": 899.99,
  "weight": 0.5
}
```

**Exemplo de cURL:**

```bash
curl -X POST http://localhost:8080/api/products/add \
     -H "Content-Type: application/json" \
     -d '{
           "productName": "Smartphone",
           "supplier": "Samsung",
           "imageUrl": "https://example.com/image.jpg",
           "price": 899.99,
           "weight": 0.5
         }'
```

---

### 2. Listar Todos os Produtos

**URL:** `/api/products/all`  
**Método:** `GET`  
**Descrição:** Retorna uma lista com todos os produtos.

**Exemplo de cURL:**

```bash
curl -X GET http://localhost:8080/api/products/all
```

---

### 3. Buscar Produto por ID

**URL:** `/api/products/get/{id}`  
**Método:** `GET`  
**Descrição:** Retorna os detalhes de um produto específico, baseado no seu ID.

**Exemplo de cURL:**

```bash
curl -X GET http://localhost:8080/api/products/get/1
```

---

### 4. Atualizar um Produto

**URL:** `/api/products/update/{id}`  
**Método:** `PUT`  
**Descrição:** Atualiza os detalhes de um produto específico, baseado no seu ID.  
**Exemplo de Payload (JSON):**

```json
{
  "productName": "Updated Smartphone",
  "supplier": "Samsung",
  "imageUrl": "https://example.com/updated_image.jpg",
  "price": 999.99,
  "weight": 0.6
}
```

**Exemplo de cURL:**

```bash
curl -X PUT http://localhost:8080/api/products/update/1 \
     -H "Content-Type: application/json" \
     -d '{
           "productName": "Updated Smartphone",
           "supplier": "Samsung",
           "imageUrl": "https://example.com/updated_image.jpg",
           "price": 999.99,
           "weight": 0.6
         }'
```

---

### 5. Deletar um Produto

**URL:** `/api/products/delete/{id}`  
**Método:** `DELETE`  
**Descrição:** Deleta um produto específico, baseado no seu ID.

**Exemplo de cURL:**

```bash
curl -X DELETE http://localhost:8080/api/products/delete/1
```

---

## Estrutura do Projeto

- **Model (`Products`):** Representa a entidade de produto no banco de dados.
- **Repository (`ProductsRepository`):** Interface que herda de `JpaRepository` para realizar operações com a entidade `Products`.
- **Service (`ProductsService`):** Contém a lógica de negócios da aplicação, como criar, buscar, atualizar e deletar produtos.
- **Controller (`ProductsController`):** Expõe os endpoints da API para que os produtos possam ser manipulados via requisições HTTP.

## Dependências Principais

As principais dependências usadas neste projeto, conforme definido no arquivo `pom.xml`, são:

- **Spring Boot Starter Data JPA:** Facilita a integração da aplicação com o banco de dados usando JPA.
- **Spring Boot Starter Web:** Permite a criação de APIs REST.
- **PostgreSQL Driver:** Driver para a conexão com o banco de dados PostgreSQL.
- **Lombok:** Reduz o código boilerplate, como getters, setters, construtores e outros métodos utilitários.

## Testando a API

Aqui estão exemplos de como você pode testar os endpoints da API usando JSON para enviar dados.

### Adicionar um Produto

```bash
curl -X POST http://localhost:8080/api/products/add \
     -H "Content-Type: application/json" \
     -d '{
           "productName": "Smartphone",
           "supplier": "Samsung",
           "imageUrl": "https://example.com/image.jpg",
           "price": 899.99,
           "weight": 0.5
         }'
```

### Listar Todos os Produtos

```bash
curl -X GET http://localhost:8080/api/products/all
```

### Buscar Produto por ID

```bash
curl -X GET http://localhost:8080/api/products/get/1
```

### Atualizar um Produto

```bash
curl -X PUT http://localhost:8080/api/products/update/1 \
     -H "Content-Type: application/json" \
     -d '{
           "productName": "Updated Smartphone",
           "supplier": "Samsung",
           "imageUrl": "https://example.com/updated_image.jpg",
           "price": 999.99,
           "weight": 0.6
         }'
```

### Deletar um Produto

```bash
curl -X DELETE http://localhost:8080/api/products/delete/1
```

## Contato:

Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para abrir uma issue no repositório do GitHub ou enviar um e-mail para: 
[nathanfelipi2006@gmail.com].

---

Desenvolvido com ❤️ por [Nathan Felipi Almeida].
