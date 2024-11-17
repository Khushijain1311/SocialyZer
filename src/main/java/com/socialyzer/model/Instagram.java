package com.socialyzer.model;

public class Instagram  extends SocialMedia{
	public Instagram() {
		this.platform= "Instagram";
	}
	public Instagram(String username, String url, int followerCount)
	{
		super(username, url, followerCount);
		
		this.platform= "Instagram";
	}

	
	public  String getPlatform() {
		return platform;
	}
	@Override
	public String toString() {
		return "Instagram [username=" + username + ", url=" + url + ", followerCount=" + followerCount +this.platform+ "]";
	}
	
	

}
