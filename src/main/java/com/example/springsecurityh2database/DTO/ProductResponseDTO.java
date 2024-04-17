package com.example.springsecurityh2database.DTO;

import com.example.springsecurityh2database.entites.Product;

public record ProductResponseDTO(String id, String name, Double price) {

    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }
}
