package com.cts.articlesearch.bean;

public class SignupStatus {
	
	private boolean status;
	private String message;
	public SignupStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignupStatus(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "SignupStatus [status=" + status + ", message=" + message + "]";
	}
	
	

}
