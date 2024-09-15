package dev.nathan.products.repository;

import dev.nathan.products.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório JPA para a entidade Products.
 * Fornece métodos CRUD automáticos.
 */
public interface ProductsRepository extends JpaRepository<Products, Long> {
}