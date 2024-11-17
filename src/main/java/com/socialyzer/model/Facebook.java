package com.socialyzer.model;

public class Facebook  extends SocialMedia{
	public Facebook()
	{
		this.platform="FaceBook";
		
	}
	
	public Facebook(String username, String url, int followerCount)
	{
		super(username, url, followerCount);
		this.platform="Facebook";
	}
	

	public String getPlatform() {
		return platform;
	}

	@Override
	public String toString() {
		return "Facebook [username=" + username + ", url=" + url + ", followerCount=" + followerCount + this.platform+"]";
	}
	

}
