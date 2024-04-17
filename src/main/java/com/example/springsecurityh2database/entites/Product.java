package com.example.springsecurityh2database.entites;

import com.example.springsecurityh2database.DTO.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Double price;

    public Product(ProductRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
    }
}
