package dev.nathan.products.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Product entity representing a product in the system.
 * This class is mapped to a table in the database and holds
 * all relevant product information.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products {

    /**
     * Unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the product.
     */
    @Column(nullable = false)
    private String productName;

    /**
     * Supplier of the product.
     */
    @Column(nullable = false)
    private String supplier;

    /**
     * Image URL of the product.
     */
    @Column(nullable = false)
    private String imageUrl;

    /**
     * Price of the product.
     */
    @Column(nullable = false)
    private double price;

    /**
     * Weight of the product.
     */
    @Column(nullable = false)
    private double weight;
}
