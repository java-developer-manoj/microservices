package com.authservice.service.impl;

import com.authservice.entity.User;
import com.authservice.repository.UserRepository;
import com.authservice.service.AuthService;
import com.authservice.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Override
    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Created Successfully!!";
    }

    @Override
    public String generateToken(String userName) {
        return jwtService.generateToken(userName);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
