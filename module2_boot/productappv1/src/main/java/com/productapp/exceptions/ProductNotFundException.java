package com.productapp.exceptions;
//user define ex
public class ProductNotFundException extends RuntimeException{

	public ProductNotFundException(String message) {
		super(message);
	}
}
