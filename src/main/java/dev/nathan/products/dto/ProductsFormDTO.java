package dev.nathan.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO to create and update products.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsFormDTO {
    private String productName;
    private String supplier;
    private String imageUrl;
    private double price;
    private double weight;
}
