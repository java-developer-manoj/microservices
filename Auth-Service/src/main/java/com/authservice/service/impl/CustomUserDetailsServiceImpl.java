package com.authservice.service.impl;

import com.authservice.entity.User;
import com.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user= repository.findByName(name);

        return new CustomUserDetailsImpl(user.orElseThrow(()->new UsernameNotFoundException("User Not Found!!!")));
    }
}
