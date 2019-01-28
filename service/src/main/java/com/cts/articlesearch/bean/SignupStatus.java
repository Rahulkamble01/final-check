package com.cts.articlesearch.bean;

public class SignupStatus {
	
	private boolean stauts;
	private String message;
	public SignupStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignupStatus(boolean stauts, String message) {
		super();
		this.stauts = stauts;
		this.message = message;
	}
	public boolean isStauts() {
		return stauts;
	}
	public void setStauts(boolean stauts) {
		this.stauts = stauts;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "SignupStatus [stauts=" + stauts + ", message=" + message + "]";
	}
	
	

}
