package dev.nathan.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for product data transfer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
    private Long id;
    private String productName;
    private String supplier;
    private String imageUrl;
    private double price;
    private double weight;
}
