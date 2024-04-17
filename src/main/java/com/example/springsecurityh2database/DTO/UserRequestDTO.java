package com.example.springsecurityh2database.DTO;

import com.example.springsecurityh2database.entites.enums.UserRole;

public record UserRequestDTO(String name, String password, UserRole role) {
}
