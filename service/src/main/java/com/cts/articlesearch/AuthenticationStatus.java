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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (authenticate ? 1231 : 1237);
		result = prime * result + (isAdmin ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthenticationStatus other = (AuthenticationStatus) obj;
		if (authenticate != other.authenticate)
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		return true;
	}


	
}
