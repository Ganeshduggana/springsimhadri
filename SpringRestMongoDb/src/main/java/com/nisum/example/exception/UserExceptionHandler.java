package com.nisum.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice	
public class UserExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException une){
		UserErrorResponse userErrorResponse = new UserErrorResponse();
		userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		userErrorResponse.setMessage("user not found ");
		userErrorResponse.setErrorCode("4444");
		userErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<UserErrorResponse>(userErrorResponse,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(Exception ex){
		UserErrorResponse userErrorResponse = new UserErrorResponse();
		userErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		userErrorResponse.setMessage("please send correct user_id");
		userErrorResponse.setErrorCode("4445");
		userErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<UserErrorResponse>(userErrorResponse,HttpStatus.BAD_REQUEST);
		
	}
}
