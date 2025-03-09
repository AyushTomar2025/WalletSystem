package com.example.wallet.exceptions;

/*
 * 
 * @Author : Ayush Tomar
 * 
 * Error response body.
 * */

public class ErrorResponse {
    private String message;
   

    public ErrorResponse(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}