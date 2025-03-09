package com.example.wallet.exceptions;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Class for Invalid Amount Exception
 * */
public class InvalidAmountException extends RuntimeException {
    
    public InvalidAmountException(String message) {
        super(message);
    }
}
