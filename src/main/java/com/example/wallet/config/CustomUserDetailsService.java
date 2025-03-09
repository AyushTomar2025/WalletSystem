package com.example.wallet.config;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.wallet.entity.Users;
import com.example.wallet.repository.UsersRepository;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Configuring UserDetailsService from spring security
 * */

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository userRepository;

    public CustomUserDetailsService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
