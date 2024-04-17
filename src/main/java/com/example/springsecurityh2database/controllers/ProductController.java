package com.example.springsecurityh2database.controllers;

import com.example.springsecurityh2database.DTO.ProductRequestDTO;
import com.example.springsecurityh2database.DTO.ProductResponseDTO;
import com.example.springsecurityh2database.repository.ProductRepository;
import com.example.springsecurityh2database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductResponseDTO>> findAll() {

        List<ProductResponseDTO> list = this.productRepository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody ProductRequestDTO productRequestDTO) {

        ProductRequestDTO saveProduct = productService.insert(productRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{name}").buildAndExpand(saveProduct).toUri();

        return ResponseEntity.created(uri).body(saveProduct);
    }
}
