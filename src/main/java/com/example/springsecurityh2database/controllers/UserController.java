package com.example.springsecurityh2database.controllers;

import com.example.springsecurityh2database.DTO.TokenResponseDTO;
import com.example.springsecurityh2database.DTO.UserLoginDTO;
import com.example.springsecurityh2database.DTO.UserRequestDTO;
import com.example.springsecurityh2database.entites.User;
import com.example.springsecurityh2database.repository.UserRepository;
import com.example.springsecurityh2database.service.TokenService;
import com.example.springsecurityh2database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRequestDTO userRequestDTO) {

        if(this.userRepository.findByLogin(userRequestDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        UserRequestDTO newUser = userService.register(userRequestDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{login}").buildAndExpand(newUser).toUri();
        String msg = "User Created";

        return ResponseEntity.created(uri).body(msg);

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDTO userLoginDTO) {

        var userNamePassword = new UsernamePasswordAuthenticationToken(userLoginDTO.login(), userLoginDTO.password());

        var authorization = authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) authorization.getPrincipal());

        return ResponseEntity.ok(new TokenResponseDTO(token));
    }



}
