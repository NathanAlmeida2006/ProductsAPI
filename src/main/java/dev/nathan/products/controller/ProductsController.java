package dev.nathan.products.controller;

import dev.nathan.products.model.Products;
import dev.nathan.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para operações relacionadas a produtos.
 */
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    /**
     * Adiciona um novo produto.
     *
     * @param product O produto a ser adicionado.
     * @return O produto adicionado com status HTTP 201 (Created).
     */
    @PostMapping("/add")
    public ResponseEntity<Products> addProduct(@RequestBody Products product) {
        Products newProduct = productsService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    /**
     * Retorna todos os produtos.
     *
     * @return Lista de produtos com status HTTP 200 (OK).
     */
    @GetMapping("/all")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> allProducts = productsService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * @param id O ID do produto a ser buscado.
     * @return O produto com status HTTP 200 (OK), se encontrado.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Products>> getById(@PathVariable Long id) {
        Optional<Products> product = productsService.getByIdProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Atualiza um produto existente.
     *
     * @param id             O ID do produto a ser atualizado.
     * @param productDetails Os novos detalhes do produto.
     * @return O produto atualizado com status HTTP 200 (OK).
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products productDetails) {
        Products updatedProduct = productsService.updateProduct(id, productDetails);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    /**
     * Deleta um produto pelo seu ID.
     *
     * @param id O ID do produto a ser deletado.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }
}
