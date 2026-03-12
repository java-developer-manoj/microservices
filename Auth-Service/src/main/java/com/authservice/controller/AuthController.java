package com.authservice.controller;

import com.authservice.dto.AuthRequest;
import com.authservice.entity.User;
import com.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;



    @GetMapping("/get")
    public ResponseEntity<?> get() {

        return ResponseEntity.ok("Auth Service!!");
    }
    @PostMapping("/userRegister")
    public ResponseEntity<?> saveUser(@RequestBody  User user) {
        final String msg = authService.saveUser(user);
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) {
        final Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
         String token=null;
        if (authenticate.isAuthenticated()) {
            token  = authService.generateToken(authRequest.getName());
        }
        else {
            throw new RuntimeException("Invalid Password/Username");
        }
        return ResponseEntity.ok(token);
    }

    @PostMapping("/validateToken")
    public ResponseEntity<?> validateToken(@RequestParam("token") String  token) {
        authService.validateToken(token);
        return ResponseEntity.ok("Token is valid");
    }


}
