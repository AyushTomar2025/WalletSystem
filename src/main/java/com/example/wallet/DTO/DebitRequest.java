package com.example.wallet.DTO;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Request body for get debit amount.
 * */
public class DebitRequest {
	
	public DebitRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DebitRequest(Integer debitAmount) {
		super();
		this.debitAmount = debitAmount;
	}

	public Integer getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Integer debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Integer debitAmount;
	
}
