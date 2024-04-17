package com.example.springsecurityh2database.DTO;

import com.example.springsecurityh2database.entites.User;
import com.example.springsecurityh2database.entites.enums.UserRole;

public record UserRegisterDTO(String id, String name, String password, UserRole role) {

    public UserRegisterDTO(User user) {
        this(user.getId(), user.getName(), user.getPassword(), user.getRole());
    }
}
