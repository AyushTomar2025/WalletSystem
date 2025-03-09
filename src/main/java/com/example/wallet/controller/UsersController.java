package com.example.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.entity.Users;
import com.example.wallet.service.UsersService;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Controller for user related endpoints.
 * */
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired 
	UsersService userService;
	
	/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Creates user. Sending email, userName or password as blank or null generates exceptions.
	 * Sending email that is already stored generates exceptions.
	 * 
	 * Return type : ResponseEntity<Users>
	 * 
	 * URL : /users/createUser
	 * */
	@PostMapping("/createUser")
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
	
	    return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));

	}
		
}