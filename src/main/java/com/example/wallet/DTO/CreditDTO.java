package com.example.wallet.DTO;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Data transfer object for credit.
 * */
public class CreditDTO {

	public String message;
	public Integer balanceLeft;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getBalanceLeft() {
		return balanceLeft;
	}
	public void setBalanceLeft(Integer balanceLeft) {
		this.balanceLeft = balanceLeft;
	}
	@Override
	public String toString() {
		return "CreditDTO [message=" + message + ", balanceLeft=" + balanceLeft + "]";
	}
	public CreditDTO(String message, Integer balanceLeft) {
		super();
		this.message = message;
		this.balanceLeft = balanceLeft;
	}
	public CreditDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
