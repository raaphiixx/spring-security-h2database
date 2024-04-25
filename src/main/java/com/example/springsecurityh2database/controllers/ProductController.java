package com.example.springsecurityh2database.controllers;

import com.example.springsecurityh2database.DTO.ProductRequestDTO;
import com.example.springsecurityh2database.repository.ProductRepository;
import com.example.springsecurityh2database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @GetMapping
    public ResponseEntity<List<ProductRequestDTO>> findAll() {

        List<ProductRequestDTO> list = productService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/insert")
    public ResponseEntity insert(@RequestBody ProductRequestDTO productRequestDTO) {

        ProductRequestDTO saveProduct = productService.insert(productRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{login}").buildAndExpand(saveProduct).toUri();

        return ResponseEntity.created(uri).body(saveProduct);
    }
}
