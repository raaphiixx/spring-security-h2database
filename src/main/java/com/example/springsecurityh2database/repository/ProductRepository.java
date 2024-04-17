package com.example.springsecurityh2database.repository;

import com.example.springsecurityh2database.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
