package com.example.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.example.wallet.entity.Wallet;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Repository Interface for Wallet
 * */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>{
	
}
