package com.example.wallet.DTO;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Data transfer object for get balance.
 * */
public class BalanceDTO {
	

	public Integer balance;
	
		public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public BalanceDTO( Integer balance) {
		super();
		this.balance = balance;
	}
	public BalanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	

}
