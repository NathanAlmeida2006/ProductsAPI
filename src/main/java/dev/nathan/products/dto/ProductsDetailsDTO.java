package dev.nathan.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO to display details of a specific product.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDetailsDTO {
    private Long id;
    private String productName;
    private String supplier;
    private double price;
    private double weight;
}
