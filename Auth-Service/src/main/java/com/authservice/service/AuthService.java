package com.authservice.service;

import com.authservice.entity.User;

public interface AuthService {

    String saveUser(User user);
    String generateToken(String userName);
    void  validateToken(String token);
}
