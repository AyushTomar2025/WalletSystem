package com.example.wallet.service;

import java.security.Principal; 
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wallet.DTO.TransactionsDTO;
import com.example.wallet.entity.Transactions;
import com.example.wallet.entity.Users;
import com.example.wallet.entity.Wallet;
import com.example.wallet.exceptions.InvalidUserException;
import com.example.wallet.repository.UsersRepository;
import com.example.wallet.repository.WalletRepository;
/*
 * 
 * @Author : Ayush Tomar
 * 
 * Service class for Transactions
 * */

@Service
public class TrasnsactionsServiceImpl implements TransactionsService{
	
	@Autowired
	UsersRepository userRepository;
	@Autowired
	WalletRepository walletRepository;

	/*
	 * @Author : Ayush Tomar
	 *Method implementation forgetting transaction. 
	 * */
	public List<TransactionsDTO> getTransactions(Long userId, Principal principal){
		//Try to fetch user by user ID
		Optional<Users> user = userRepository.findById(userId);
		
		//If user is present, get transactions
		if(user.isPresent()) {
			
			// If the email of the logged-in user does not match the requested user, throw an error
			if(!principal.getName().equals( user.get().getEmail()))
				throw new InvalidUserException("Invalid User ID");
				
			//Retieve wallet from user
			Long walletId = user.get().getWallet().getWalletId();
			Optional<Wallet> wallet = walletRepository.findById(walletId);
			
			//Retrieve transactions form wallet
			List<Transactions> transactionsList = wallet.get().getTransactions();
			List<TransactionsDTO> transactionsDTOList = new ArrayList<>();
		
			// Make time stamp readable
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			//Create List of transaction DTO
			for(Transactions transactionsIterator : transactionsList) {
				transactionsDTOList.add(new TransactionsDTO(transactionsIterator.getTransactionsType() + " "+ transactionsIterator.getAmount(), transactionsIterator.getCreatedAt().format(formatter)));		
			}
			
			//Return List of transaction DTO
			return transactionsDTOList;
		}
		
		//Throw error f wrong userID is sent
		throw new InvalidUserException("Invalid User ID");
	}
}
