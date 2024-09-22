package dev.nathan.products.service;

import dev.nathan.products.dto.ProductsDTO;
import dev.nathan.products.dto.ProductsFormDTO;
import dev.nathan.products.dto.ProductsDetailsDTO;
import dev.nathan.products.model.Products;
import dev.nathan.products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for handling product-related operations.
 */
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    /**
     * Creates a new product.
     *
     * @param formDTO DTO containing product details.
     * @return The created product.
     */
    public ProductsDTO createProduct(ProductsFormDTO formDTO) {
        Products product = new Products();
        product.setProductName(formDTO.getProductName());
        product.setSupplier(formDTO.getSupplier());
        product.setImageUrl(formDTO.getImageUrl());
        product.setPrice(formDTO.getPrice());
        product.setWeight(formDTO.getWeight());

        Products savedProduct = productsRepository.save(product);
        return convertToDTO(savedProduct);
    }

    /**
     * Gets all products.
     *
     * @return A list of all products.
     */
    public List<ProductsDTO> getAllProducts() {
        return productsRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Gets product details by ID.
     *
     * @param id The ID of the product.
     * @return Product details.
     */
    public ProductsDetailsDTO getProductById(Long id) {
        Products product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return convertToDetailsDTO(product);
    }

    /**
     * Updates an existing product.
     *
     * @param id      The ID of the product to be updated.
     * @param formDTO DTO containing updated product details.
     * @return The updated product.
     */
    public ProductsDTO updateProduct(Long id, ProductsFormDTO formDTO) {
        Products product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(formDTO.getProductName());
        product.setSupplier(formDTO.getSupplier());
        product.setImageUrl(formDTO.getImageUrl());
        product.setPrice(formDTO.getPrice());
        product.setWeight(formDTO.getWeight());

        Products updatedProduct = productsRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to be deleted.
     */
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

    private ProductsDTO convertToDTO(Products product) {
        return new ProductsDTO(product.getId(), product.getProductName(), product.getSupplier(),
                product.getImageUrl(), product.getPrice(), product.getWeight());
    }

    private ProductsDetailsDTO convertToDetailsDTO(Products product) {
        return new ProductsDetailsDTO(product.getId(), product.getProductName(),
                product.getSupplier(), product.getPrice(), product.getWeight());
    }
}
