package com.example.wallet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*
 * 
 * @Author : Ayush Tomar
 * 
 * GLoabl exceptions handler
 * */

@ControllerAdvice 
public class GlobalExceptionHandler {
	
	/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Used when credit amount is more than balance
	 * */

	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(InsufficientBalanceException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	/*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Generic error
	 * */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        ErrorResponse error = new ErrorResponse("Something went wrong");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    /*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Used when credit or debit amount is less than or equal to 0.
	 * */
    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<String> handleInvalidAmountException(InvalidAmountException e) {
    	ErrorResponse error = new ErrorResponse(e.getMessage());
    	return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
    }


    /*
	 * 
	 * @Author : Ayush Tomar
	 * 
	 * Used when logged in user ID is using other user's user ID 
	 * */
    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<String> handleInvalidUserException(InvalidUserException e) {
    	ErrorResponse error = new ErrorResponse(e.getMessage());
    	return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
    }
 
} 