package com.cts.articlesearch;

import com.cts.articlesearch.bean.User;

public class AuthenticationStatus {
	
	private boolean authenticate;
	private boolean isAdmin;
	private User user;
	
	public AuthenticationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationStatus(boolean authenticate, boolean isAdmin, User user) {
		super();
		this.authenticate = authenticate;
		this.isAdmin = isAdmin;
		this.user = user;
	}

	public boolean isAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authenticate=" + authenticate + ", isAdmin=" + isAdmin + ", user=" + user + "]";
	}

	
}
