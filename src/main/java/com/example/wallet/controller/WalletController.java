package com.example.wallet.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.DTO.BalanceDTO;
import com.example.wallet.DTO.CreditDTO;
import com.example.wallet.DTO.CreditRequest;
import com.example.wallet.DTO.DebitDTO;
import com.example.wallet.DTO.DebitRequest;
import com.example.wallet.exceptions.InvalidAmountException;
import com.example.wallet.service.WalletService;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Controller for wallet related endpoints.
 * */
@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	WalletService walletService;
	
	/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Gets Balance. 
	 * Not sending logged in user's user ID throws exception.
	  
	 * Return type : ResponseEntity<BalanceDTO>
	 * 
	 * URL : /wallet/getBalance/{userID}
	 * */

	 @GetMapping("/getBalance/{userID}")
	 public ResponseEntity<BalanceDTO> getBalance(@PathVariable Long userID, Principal principal) {

		 BalanceDTO balance = walletService.getBalance(userID, principal);

	     return ResponseEntity.ok(balance); 
	    }
	
	 /*
		 * 
		 * @Author : Ayush Tomar
		 * 
		 * Credit in wallet. 
		 * Not sending logged in user's user ID throws exception.
		 * If credit amount is more than balance, an exception is thrown
		 * If credit Amount is lower than or equal to 0 then exception is thrown
		  
		 * Return type : ResponseEntity<BalanceDTO>
		 * 
		 * URL : /wallet/credit/{userID}
		 * */
	@PostMapping("credit/{userID}")
	public ResponseEntity<CreditDTO> credit(@PathVariable Long userID, @RequestBody CreditRequest creditAmount, Principal principal) {
			
		   //Checking for negative values
		   if (creditAmount.getCreditAmount() <= 0) {
	            throw new InvalidAmountException("Invalid credit amount. Credit amount cannot be 0 or less than 0.");
	        }
		   
	        CreditDTO creditResponse = walletService.credit(userID, creditAmount, principal);
	        
	        return ResponseEntity.ok(creditResponse);
	}
	
	 /*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Debit in wallet. 
	 * Not sending logged in user's user ID throws exception.
	 * If debit Amount is lower than or equal to 0 then exception is thrown
	  
	 * Return type : ResponseEntity<BalanceDTO>
	 * 
	 * URL : /wallet/debit/{userID}
	 * */
	@PostMapping("debit/{userID}")
	public ResponseEntity<DebitDTO> debit(@PathVariable Long userID, @RequestBody DebitRequest debitAmount, Principal principal) {
			
			//Checking for negative values
		  	if (debitAmount.getDebitAmount() <= 0) {
	            throw new InvalidAmountException("Invalid debit amount. Debit amount cannot be 0 or less than 0");
	        }
		  
	        DebitDTO debitResponse = walletService.debit(userID, debitAmount, principal);
	        return ResponseEntity.ok(debitResponse);
	}
	
}