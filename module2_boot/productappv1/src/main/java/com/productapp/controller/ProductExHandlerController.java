package com.productapp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorInfo;
import com.productapp.exceptions.ProductNotFundException;

@RestControllerAdvice	//AOP under the hood Aspect Oriented Programming
public class ProductExHandlerController {

	//U want to handle 404
	@ExceptionHandler(ProductNotFundException.class)
	public ResponseEntity<ErrorInfo> handle404Error(ProductNotFundException ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(ex.getMessage());
		errorInfo.setStatus(404);
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setToContact("amit@oracle.com");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
}








