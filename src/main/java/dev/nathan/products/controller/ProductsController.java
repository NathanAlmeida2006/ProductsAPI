package dev.nathan.products.controller;

import dev.nathan.products.dto.ProductsDTO;
import dev.nathan.products.dto.ProductsFormDTO;
import dev.nathan.products.dto.ProductsDetailsDTO;
import dev.nathan.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for handling product operations.
 */
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    /**
     * Adds a new product.
     *
     * @param formDTO DTO with product details to be added.
     * @return Added product with HTTP 201 status.
     */
    @PostMapping("/add")
    public ResponseEntity<ProductsDTO> addProduct(@RequestBody ProductsFormDTO formDTO) {
        ProductsDTO newProduct = productsService.createProduct(formDTO);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    /**
     * Returns all products.
     *
     * @return List of products with HTTP 200 status.
     */
    @GetMapping("/all")
    public ResponseEntity<List<ProductsDTO>> getAllProducts() {
        List<ProductsDTO> allProducts = productsService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    /**
     * Finds a product by its ID.
     *
     * @param id The ID of the product to be found.
     * @return Product details with HTTP 200 status if found.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<ProductsDetailsDTO> getProductById(@PathVariable Long id) {
        ProductsDetailsDTO productDetails = productsService.getProductById(id);
        return new ResponseEntity<>(productDetails, HttpStatus.OK);
    }

    /**
     * Updates an existing product.
     *
     * @param id      The ID of the product to be updated.
     * @param formDTO DTO with the updated product details.
     * @return Updated product with HTTP 200 status.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductsDTO> updateProduct(@PathVariable Long id, @RequestBody ProductsFormDTO formDTO) {
        ProductsDTO updatedProduct = productsService.updateProduct(id, formDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to be deleted.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
