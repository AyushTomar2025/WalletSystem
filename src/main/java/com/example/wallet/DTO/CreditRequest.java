package com.example.wallet.DTO;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Request body for get credit amount.
 * */
public class CreditRequest {

	public Integer creditAmount;

	public CreditRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditRequest(Integer creditAmount) {
		super();
		this.creditAmount = creditAmount;
	}


	public void setCreditAmount(Integer creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Integer getCreditAmount() {
		// TODO Auto-generated method stub
		return creditAmount;
	}
	
}
