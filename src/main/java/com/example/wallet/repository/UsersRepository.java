package com.example.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wallet.entity.Users;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Repository Interface for User
 * */
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Optional<Users> findByEmail(String email);
	
	
	

}
