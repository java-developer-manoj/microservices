package com.authservice.service;

import org.springframework.stereotype.Service;

@Service
public interface JWTService {

    String generateToken(String userName);
    void validateToken(final String token);
}
