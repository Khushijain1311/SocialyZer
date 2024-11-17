package com.socialyzer.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Follower implements Comparable<Follower> {
	private Account account;
	private int followerCount;
	private LocalDateTime timeStp;
	
	public Follower()
	{
		super();
	}

	public Follower(Account account, int followerCount, LocalDateTime timeStp) {
		super();
		this.account = account;
		this.followerCount = followerCount;
		this.timeStp = timeStp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}

	public LocalDateTime getTimeStp() {
		return timeStp;
	}

	public void setTimeStp(LocalDateTime timeStp) {
		this.timeStp = timeStp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, followerCount, timeStp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Follower other = (Follower) obj;
		return Objects.equals(account, other.account) && followerCount == other.followerCount
				&& Objects.equals(timeStp, other.timeStp);
	}

	@Override
	public String toString() {
		return "Follower [account=" + account + ", followerCount=" + followerCount + ", timeStp=" + timeStp + "]";
	}

	@Override
	public int compareTo(Follower o) {

		return this.followerCount-o.followerCount;
	}
	
	
	

}
