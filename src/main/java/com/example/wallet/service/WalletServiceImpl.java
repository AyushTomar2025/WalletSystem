package com.example.wallet.service;

import java.security.Principal; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wallet.DTO.BalanceDTO;
import com.example.wallet.DTO.CreditDTO;
import com.example.wallet.DTO.CreditRequest;
import com.example.wallet.DTO.DebitDTO;
import com.example.wallet.DTO.DebitRequest;
import com.example.wallet.entity.Transactions;
import com.example.wallet.entity.Users;
import com.example.wallet.entity.Wallet;
import com.example.wallet.exceptions.InsufficientBalanceException;
import com.example.wallet.exceptions.InvalidUserException;
import com.example.wallet.repository.TransactionsRepository;
import com.example.wallet.repository.UsersRepository;
import com.example.wallet.repository.WalletRepository;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Service class for User
 * */

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	UsersRepository userRepository;
	@Autowired
	WalletRepository walletRepository;
	@Autowired
	TransactionsRepository transactionsRepository;
	
	/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Method implementation to get balance
	 * */
	public BalanceDTO getBalance(Long userID, Principal principal) {
		
		//Fetch user
		Optional<Users> user = userRepository.findById(userID);	
		
		//If user is present get balance
		if(user.isPresent()) {
			
			Users newUser = user.get();

			// If the email of the logged-in user does not match the requested user, throw an error
			if(!principal.getName().equals(newUser.getEmail()))
				throw new InvalidUserException("Invalid User ID");
				
			//Fetch wallet
			Wallet wallet = newUser.getWallet();
			//Create and return balanceDTO
			BalanceDTO balanceDTO = new BalanceDTO(wallet.getBalance());
			return balanceDTO;
		}
		//Throw error if wrong userID is sent
		throw new InvalidUserException("Invalid User ID");
		
	}
	
	/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Method implementation to credit
	 * */
	public CreditDTO credit(Long userID, CreditRequest creditAmount, Principal principal) {
		
		//Fetch user
		Optional<Users> user = userRepository.findById(userID);	
		
		//If user is present, proceed with credit operation
		if(user.isPresent()) {
			
			Users newUser = user.get();
			
			// If the email of the logged-in user does not match the requested user, throw an error
			if(!principal.getName().equals( newUser.getEmail()))
				throw new InvalidUserException("Invalid User ID");
			
			
			//Fetch wallet
			Wallet wallet = newUser.getWallet();
			Integer oldBalance = wallet.getBalance();
			
			//Throw error is trying to credit more than current balance
		    if (oldBalance < creditAmount.getCreditAmount()) {
		        throw new InsufficientBalanceException("Not enough balance!");
		    }
			
		    //Subtract credit amount from balance.
			wallet.setBalance(oldBalance - creditAmount.getCreditAmount());
			
			// Create a new transaction record for c operation
			Transactions transaction = new Transactions();
			transaction.setAmount(creditAmount.getCreditAmount());
			transaction.setTransactionsType("Credit");
			transaction.setWallet(wallet);
			transactionsRepository.save(transaction);
			
			//Create and return Credit DTO
			CreditDTO creditDTO = new CreditDTO("Amount Credited", oldBalance - creditAmount.getCreditAmount());
			return creditDTO;
	}
		//Throw error if wrong userID is sent
		throw new InvalidUserException("Invalid User ID");

	}	

	/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Method implementation to debit
	 * */
	public DebitDTO debit(Long userID, DebitRequest debitRequest, Principal principal) { 
		
		// Fetch user
		Optional<Users> user = userRepository.findById(userID);	
		
		// If user exists, proceed with debit operation
		if(user.isPresent()) {
			
			Users newUser = user.get();
			
			// If the email of the logged-in user does not match the requested user, throw an error
			if(!principal.getName().equals(newUser.getEmail()))
				throw new InvalidUserException("Invalid User ID");
			
			// Fetch the user's wallet
			Wallet wallet = newUser.getWallet();
			Integer oldBalance = wallet.getBalance();
			
			// Add the debited amount to the balance
			wallet.setBalance(oldBalance + debitRequest.getDebitAmount());
			
			// Create a new transaction record for debit operation
			Transactions transaction = new Transactions();
			transaction.setAmount(debitRequest.getDebitAmount());
			transaction.setTransactionsType("Debit");
			transaction.setWallet(wallet);
			transactionsRepository.save(transaction);
			
			// Create and return a DebitDTO response
			DebitDTO debitDTO = new DebitDTO("Amount Debited", oldBalance + debitRequest.getDebitAmount());
			return debitDTO;
		}
		
		// Throw error if an invalid userID is provided
		throw new InvalidUserException("Invalid User ID");
	}	

}
