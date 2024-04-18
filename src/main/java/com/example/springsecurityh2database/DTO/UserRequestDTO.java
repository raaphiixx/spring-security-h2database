package com.example.springsecurityh2database.DTO;

import com.example.springsecurityh2database.entites.enums.UserRole;

public record UserRequestDTO(String login, String password, UserRole role) {
}
