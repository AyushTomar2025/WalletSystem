package com.example.wallet.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.DTO.TransactionsDTO;
import com.example.wallet.service.TransactionsService;


/*
 * 
 * @Author : Ayush Tomar
 * 
 * Controller for transactions related endpoints.
 * */
@RestController
@RequestMapping("/transactions")
public class TransactionsController {

	@Autowired
	TransactionsService transactionsService;
	
	/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Get transactions.
	 * Endpoint : /transactions/getTransactions/{userID}
	 * */
	@GetMapping("/getTransactions/{userId}")
	public ResponseEntity<?> getTransactions(@PathVariable Long userId, Principal principal) {
		
	    List<TransactionsDTO> transactions = transactionsService.getTransactions(userId, principal);
	    
	    //If transaction is empty return "No transactions have been made so far" else return list of transactions. 
	    if (transactions.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No transactions have been made so far.");
	    } else {
	        return ResponseEntity.status(HttpStatus.OK).body(transactions);
	    }
	}
}