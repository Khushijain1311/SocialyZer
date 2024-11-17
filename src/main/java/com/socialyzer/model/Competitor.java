package com.socialyzer.model;

import java.util.Objects;

public class Competitor  {
	private Account account;
	private Account competitor;
	public Competitor()
	{
		super();
	}
	public Competitor(Account account, Account competitor) {
		super();
		this.account = account;
		this.competitor = competitor;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Account getCompetitor() {
		return competitor;
	}
	public void setCompetitor(Account competitor) {
		this.competitor = competitor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(account, competitor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competitor other = (Competitor) obj;
		return Objects.equals(account, other.account) && Objects.equals(competitor, other.competitor);
	}
	@Override
	public String toString() {
		return "Competitor [account=" + account + ", competitor=" + competitor + "]";
	}
	
	
	

}
