package com.bankapp.dto;

import java.time.LocalDateTime;

public class ErrorInfo {
	private String message;
    private String status;
    private LocalDateTime timestamp;
    private String tocontact;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getTocontact() {
		return tocontact;
	}
	public void setTocontact(String tocontact) {
		this.tocontact = tocontact;
	}
	public ErrorInfo(String message, String status, LocalDateTime timestamp, String tocontact) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
		this.tocontact = tocontact;
	}
	public ErrorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErrorInfo [message=" + message + ", status=" + status + ", timestamp=" + timestamp + ", tocontact="
				+ tocontact + "]";
	}
    
    
    
}
