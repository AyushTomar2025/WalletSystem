package com.example.wallet.DTO;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Data transfer object for Transactions.
 * */
public class TransactionsDTO {
	
	public String transaction;
	public String timeStamp;

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public TransactionsDTO(String transaction, String string) {
		super();
		this.transaction = transaction;
		this.timeStamp = string;
	}



}
