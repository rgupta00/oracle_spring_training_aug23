package com.productapp.dto;

import java.time.LocalDateTime;
//this class used to hold the error message
public class ErrorInfo {
	private LocalDateTime timestamp;
	private int status;
	private String errorMessage;
	private String toContact;
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getToContact() {
		return toContact;
	}
	public void setToContact(String toContact) {
		this.toContact = toContact;
	}
	
	
}
