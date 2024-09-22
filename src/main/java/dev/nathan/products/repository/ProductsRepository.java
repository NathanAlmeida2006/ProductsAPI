package dev.nathan.products.repository;

import dev.nathan.products.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for the Products entity.
 * Provides automatic CRUD methods.
 */
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
