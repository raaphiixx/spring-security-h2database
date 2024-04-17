package com.example.springsecurityh2database.controllers;

import com.example.springsecurityh2database.DTO.UserRequestDTO;
import com.example.springsecurityh2database.repository.UserRepository;
import com.example.springsecurityh2database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRequestDTO userRequestDTO) {

        UserRequestDTO newUser = userService.register(userRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{name}").buildAndExpand(newUser).toUri();
        String msg = "User Created";

        return ResponseEntity.created(uri).body(msg);
    }

}
