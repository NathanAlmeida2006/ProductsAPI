Here’s the updated README in English for the new version of the system:

---

# Products API

## Description

This is a simple product management API developed using **Spring Boot** and **JPA**. It allows you to create, list, update, and delete products. The API uses **PostgreSQL** as its database and includes support for **Lombok** to reduce boilerplate code.

## Requirements

- **Java 22**
- **Maven**
- **PostgreSQL**
- **Spring Boot 3.3.3**

## Database Configuration

1. Ensure that PostgreSQL is running on your machine.
2. Create a database with the desired name.
3. Update the `application.properties` file with your database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Build and Run

To build and run the project, use the following commands in your terminal:

```bash
# To build the project
mvn clean install

# To run the application
mvn spring-boot:run
```

The API will be available at: `http://localhost:8080`.

## API Endpoints

### 1. Add a Product

**URL:** `/api/products/add`  
**Method:** `POST`  
**Description:** Adds a new product.  
**Example Payload (JSON):**

```json
{
  "productName": "Smartphone",
  "supplier": "Samsung",
  "imageUrl": "https://example.com/image.jpg",
  "price": 899.99,
  "weight": 0.5
}
```

**Example cURL:**

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

### 2. List All Products

**URL:** `/api/products/all`  
**Method:** `GET`  
**Description:** Returns a list of all products.

**Example cURL:**

```bash
curl -X GET http://localhost:8080/api/products/all
```

---

### 3. Get Product by ID

**URL:** `/api/products/get/{id}`  
**Method:** `GET`  
**Description:** Returns the details of a specific product by its ID.

**Example cURL:**

```bash
curl -X GET http://localhost:8080/api/products/get/1
```

---

### 4. Update a Product

**URL:** `/api/products/update/{id}`  
**Method:** `PUT`  
**Description:** Updates the details of a specific product by its ID.  
**Example Payload (JSON):**

```json
{
  "productName": "Updated Smartphone",
  "supplier": "Samsung",
  "imageUrl": "https://example.com/updated_image.jpg",
  "price": 999.99,
  "weight": 0.6
}
```

**Example cURL:**

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

### 5. Delete a Product

**URL:** `/api/products/delete/{id}`  
**Method:** `DELETE`  
**Description:** Deletes a specific product by its ID.

**Example cURL:**

```bash
curl -X DELETE http://localhost:8080/api/products/delete/1
```

---

## Project Structure

- **Model (`Products`):** Represents the product entity in the database.
- **Repository (`ProductsRepository`):** Interface that extends `JpaRepository` to handle operations with the `Products` entity.
- **Service (`ProductsService`):** Contains the business logic of the application, including creating, retrieving, updating, and deleting products.
- **Controller (`ProductsController`):** Exposes API endpoints to handle HTTP requests for managing products.

## Main Dependencies

The main dependencies used in this project, as defined in the `pom.xml` file, include:

- **Spring Boot Starter Data JPA:** Simplifies integration with the database using JPA.
- **Spring Boot Starter Web:** Facilitates the creation of REST APIs.
- **PostgreSQL Driver:** Driver for connecting to the PostgreSQL database.
- **Lombok:** Reduces boilerplate code such as getters, setters, constructors, and utility methods.

## Testing the API

Here are examples of how you can test the API endpoints using JSON to send data.

### Add a Product

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

### List All Products

```bash
curl -X GET http://localhost:8080/api/products/all
```

### Get Product by ID

```bash
curl -X GET http://localhost:8080/api/products/get/1
```

### Update a Product

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

### Delete a Product

```bash
curl -X DELETE http://localhost:8080/api/products/delete/1
```

## Contact

If you have any questions or suggestions, feel free to open an issue in the GitHub repository or send an email to: [nathanfelipi2006@gmail.com].

---

Developed with ❤️ by [Nathan Felipi Almeida].

---