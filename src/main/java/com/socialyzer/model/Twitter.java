package com.socialyzer.model;

public class Twitter extends SocialMedia {

	
	
	

	public Twitter() {
		super();
	}
	
	public Twitter(String username, String url, int followerCount) {
		super(username, url, followerCount);
		this.platform="Twitter";
	}

	public  String getPlatform() {
		return platform; 
	}




	@Override
	public String toString() {
		return "Twitter [username=" + username + ", url=" + url + ", followerCount=" + followerCount +platform+ "]";
	}
	
	

}
