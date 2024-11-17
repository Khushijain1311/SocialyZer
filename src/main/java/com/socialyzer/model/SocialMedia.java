package com.socialyzer.model;

import java.util.Objects;

public  abstract class SocialMedia {
	
	protected String username;
	protected String url;
	protected  int followerCount;
	protected  String  platform;
	


	public SocialMedia() {
		super();
	}
	
	
	public SocialMedia(String username, String url, int followerCount)
	{
		this.username=username;
		this.url= url;
		this.followerCount= followerCount;
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public int getFollowerCount() {
		return followerCount;
	}


	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(url, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocialMedia other = (SocialMedia) obj;
		return  Objects.equals(url, other.url)
				&& Objects.equals(username, other.username);
	}
	
	
	public  abstract String getPlatform();
}
