package com.example.springsecurityh2database.service;

import com.example.springsecurityh2database.DTO.UserRequestDTO;
import com.example.springsecurityh2database.entites.User;
import com.example.springsecurityh2database.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;


    public UserRequestDTO userConverterDTO(User user) {

        return objectMapper.convertValue(user, UserRequestDTO.class);
    }

    public UserRequestDTO register(UserRequestDTO userRequestDTO) {

        String encryptPassword = new BCryptPasswordEncoder().encode(userRequestDTO.password());

        User user = new User();
        user.setLogin(userRequestDTO.login());
        user.setPassword(encryptPassword);
        user.setRole(userRequestDTO.role());
        userRepository.save(user);

        return userConverterDTO(user);
    }

}
