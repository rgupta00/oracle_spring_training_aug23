package com.bankapp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dto.ErrorInfo;
import com.bankapp.exceptions.BankAccountNotFoundException;

@RestControllerAdvice	//exception handler AOP
public class AccountExHandler {
	
	
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(BankAccountNotFoundException ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setMessage(ex.getMessage());
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setTocontact("ravi@oracle.com");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}


}
