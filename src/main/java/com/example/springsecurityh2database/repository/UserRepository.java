package com.example.springsecurityh2database.repository;

import com.example.springsecurityh2database.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
