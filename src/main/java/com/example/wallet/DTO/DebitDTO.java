package com.example.wallet.DTO;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Data transfer object for debit.
 * */
public class DebitDTO {
	
	public String message;
	public Integer newBalance;
	
	public DebitDTO(String message, Integer newBalance) {
		super();
		this.message = message;
		this.newBalance = newBalance;
	}
	public DebitDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DebitDTO [message=" + message + ", newBalance=" + newBalance + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(Integer newBalance) {
		this.newBalance = newBalance;
	}

}