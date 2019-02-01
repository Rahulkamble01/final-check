package com.cts.articlesearch;

public class ArticleStatus {
	
	private boolean isPresent;
	private String message;
	private boolean status;
	public ArticleStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleStatus(boolean isPresent, String message, boolean status) {
		super();
		this.isPresent = isPresent;
		this.message = message;
		this.status = status;
	}
	public boolean isPresent() {
		return isPresent;
	}
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ArticleStatus [isPresent=" + isPresent + ", message=" + message + ", status=" + status + "]";
	}
	
	

}
