package dev.nathan.products.service;

import dev.nathan.products.model.Products;
import dev.nathan.products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável por lidar com as operações relacionadas a produtos.
 */
@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    /**
     * Cria um novo produto e o salva no banco de dados.
     *
     * @param product O produto a ser criado.
     * @return O produto salvo.
     */
    public Products createProduct(Products product) {
        return productsRepository.save(product);
    }

    /**
     * Retorna uma lista de todos os produtos.
     *
     * @return Lista de produtos.
     */
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * @param id O ID do produto.
     * @return Um Optional contendo o produto, se encontrado.
     */
    public Optional<Products> getByIdProduct(Long id) {
        return productsRepository.findById(id);
    }

    /**
     * Atualiza as informações de um produto existente.
     *
     * @param id             O ID do produto a ser atualizado.
     * @param productDetails Os detalhes atualizados do produto.
     * @return O produto atualizado.
     */
    public Products updateProduct(Long id, Products productDetails) {
        Products product = productsRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        product.setProductName(productDetails.getProductName());
        product.setSupplier(productDetails.getSupplier());
        product.setImageUrl(productDetails.getImageUrl());
        product.setPrice(productDetails.getPrice());
        product.setWeight(productDetails.getWeight());
        return productsRepository.save(product);
    }

    /**
     * Deleta um produto pelo seu ID.
     *
     * @param id O ID do produto a ser deletado.
     */
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }
}
