package com.example.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.wallet.entity.Users;
import com.example.wallet.entity.Wallet;
import com.example.wallet.exceptions.InvalidUserException;
import com.example.wallet.repository.UsersRepository;
/*
 * 
 * @Author : Ayush Tomar
 * 
 * Service class for User
 * */

@Service
public class UsersServiceImpl implements UsersService {
    
    @Autowired
    private UsersRepository userRepository;
        
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /*
     * 
     * @Author : Ayush Tomar
     * 
     * Method implementation for creating user
     * */
    @Override
    public Users createUser(Users user) {
        
    	//Null checks and blank check on recieved values
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidUserException("Email cannot be empty.");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidUserException("Password cannot be empty.");
        }
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            throw new InvalidUserException("Username cannot be empty.");
        }
        
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new InvalidUserException("Email ID already exists");
        }

        // Ensure wallet is initialized
        if (user.getWallet() == null || user.getWallet().getBalance() == null) {
            Wallet emptyWallet = new Wallet();
            emptyWallet.setBalance(0);
            user.setWallet(emptyWallet);
        }
        
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //Return saved user
        return userRepository.save(user);
    }

}
