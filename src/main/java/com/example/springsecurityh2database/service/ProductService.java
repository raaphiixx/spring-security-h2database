package com.example.springsecurityh2database.service;

import com.example.springsecurityh2database.DTO.ProductRequestDTO;
import com.example.springsecurityh2database.entites.Product;
import com.example.springsecurityh2database.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ProductRequestDTO productConverterDTO(Product product) {
        return objectMapper.convertValue(product, ProductRequestDTO.class);
    }

    public List<ProductRequestDTO> findAll() {
        return productRepository.findAll().stream().map(this::productConverterDTO).collect(Collectors.toList());
    }

    public ProductRequestDTO insert(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.name());
        product.setPrice(productRequestDTO.price());
        productRepository.save(product);
        return productConverterDTO(product);
    }
}
