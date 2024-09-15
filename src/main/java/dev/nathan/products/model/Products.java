package dev.nathan.products.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe Products representa a entidade de um produto no sistema.
 * Ela contém atributos como nome do produto, fornecedor, URL da imagem, preço e peso.
 * Utiliza anotações JPA para mapeamento do banco de dados.
 */
@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    /**
     * Identificador único do produto, gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Nome do produto.
     */
    String productName;

    /**
     * Fornecedor do produto.
     */
    String supplier;

    /**
     * URL da imagem do produto.
     */
    String imageUrl;

    /**
     * Preço do produto.
     */
    double price;

    /**
     * Peso do produto.
     */
    double weight;
}
