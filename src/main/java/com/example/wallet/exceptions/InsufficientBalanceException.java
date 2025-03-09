package com.example.wallet.exceptions;

/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Class for Insufficient Balance Exception
	 * */

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}