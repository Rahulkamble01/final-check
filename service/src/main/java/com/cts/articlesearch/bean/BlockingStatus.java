package com.cts.articlesearch.bean;

public class BlockingStatus {
	
	private boolean isBlocking;
	private boolean isNotBlocking;
	public BlockingStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlockingStatus(boolean isBlocking, boolean isNotBlocking) {
		super();
		this.isBlocking = isBlocking;
		this.isNotBlocking = isNotBlocking;
	}
	public boolean isBlocking() {
		return isBlocking;
	}
	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}
	public boolean isNotBlocking() {
		return isNotBlocking;
	}
	public void setNotBlocking(boolean isNotBlocking) {
		this.isNotBlocking = isNotBlocking;
	}
	@Override
	public String toString() {
		return "BlockingStatus [isBlocking=" + isBlocking + ", isNotBlocking=" + isNotBlocking + "]";
	}
	
	

}
