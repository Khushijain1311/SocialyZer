package com.socialyzer.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Account implements Comparable<Account> {
	private static int counter;
	private SocialMedia socialMedia;
	private String accountID;
	private User user;
	private LocalDateTime dateJoined= LocalDateTime.now();
	
	
	{
		counter++;
		accountID="A"+counter;
	}
	
	public Account()
	{
		super();
	}
	
	
	



 
	public Account(SocialMedia socialMedia, User user) {
		super();
		this.socialMedia = socialMedia;
		this.user = user;
		this.dateJoined = LocalDateTime.now();//
	}

	

	
	public Account(SocialMedia socialMedia, String accountId, User user, LocalDateTime localDateTime) {

	this.socialMedia= socialMedia;
	this.accountID= accountId;
	this.user=user;
	this.dateJoined= localDateTime;
	}


	public Account(SocialMedia socialMedia, User user, LocalDateTime time)
	{
		this.socialMedia=socialMedia;
		this.user= user;
		this.dateJoined= time;
	}




	public SocialMedia getSocialMedia() {
		return socialMedia;
	}
	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(LocalDateTime dateJoined) {
		this.dateJoined = dateJoined;
	}
	
	@Override
	public int compareTo(Account o) {
		return this.accountID.compareTo(o.accountID);
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(accountID, socialMedia, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountID, other.accountID) && Objects.equals(socialMedia, other.socialMedia)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Account [socialMedia=" + socialMedia + ", accountID=" + accountID + ", user=" + user + ", dateJoined="
				+ dateJoined + "]";
	}

	
	
	
}
