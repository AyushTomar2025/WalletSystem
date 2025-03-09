package com.example.wallet.service;

import java.security.Principal;
import java.util.List;

import com.example.wallet.DTO.TransactionsDTO;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Service Interface for Transaction
 * */
public interface TransactionsService {
	
	public List<TransactionsDTO> getTransactions(Long userId, Principal principal);

}