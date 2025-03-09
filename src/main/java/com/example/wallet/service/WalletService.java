package com.example.wallet.service;

import java.security.Principal;

import com.example.wallet.DTO.BalanceDTO;
import com.example.wallet.DTO.CreditDTO;
import com.example.wallet.DTO.CreditRequest;
import com.example.wallet.DTO.DebitDTO;
import com.example.wallet.DTO.DebitRequest;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Service Interface for Wallet
 * */
public interface WalletService {
	
	public BalanceDTO getBalance(Long userID, Principal principal);
	public CreditDTO credit(Long userID, CreditRequest amount,Principal principal);
	public DebitDTO debit(Long userID, DebitRequest amount,Principal principal);
	
}
