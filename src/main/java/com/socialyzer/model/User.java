package com.socialyzer.model;

import java.util.Objects;

public class User  implements Comparable<User>{
	private String email;
	private String password;
	private Boolean isLogin=false;
	

	public User() {
		super();
	}
	
	public User(String email, String password)
	{
		super();
		this.email= email;
		this.password= password;
		}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) ;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", isLogin=" + isLogin + "]";
	}

	@Override
	public int compareTo(User o) {
		return this.email.compareTo(o.email);
	}
	

	

}
