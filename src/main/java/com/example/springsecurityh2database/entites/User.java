package com.example.springsecurityh2database.entites;

import com.example.springsecurityh2database.DTO.UserRegisterDTO;
import com.example.springsecurityh2database.entites.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String password;
    private UserRole role;

    public User(UserRegisterDTO data) {
        this.name = data.name();
        this.password = data.password();
        this.role = data.role();
    }
}
