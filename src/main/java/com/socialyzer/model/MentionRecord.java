package com.socialyzer.model;
import java.time.LocalDateTime;
import java.util.Objects;

public class MentionRecord  implements Comparable<MentionRecord>{
	private Account account;
	private int noOfMentions;
	private LocalDateTime timestamp;
	
	public MentionRecord()
	{
		super();
	}

	public MentionRecord(Account account, int noOfMentions, LocalDateTime timestamp) {
		super();
		this.account = account;
		this.noOfMentions = noOfMentions;
		this.timestamp = timestamp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getNoOfMentions() {
		return noOfMentions;
	}

	public void setNoOfMentions(int noOfMentions) {
		this.noOfMentions = noOfMentions;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, noOfMentions, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MentionRecord other = (MentionRecord) obj;
		return Objects.equals(account, other.account) && noOfMentions == other.noOfMentions
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "MentionRecord [account=" + account + ", noOfMentions=" + noOfMentions + ", timestamp=" + timestamp
				+ "]";
	}

	@Override
	public int compareTo(MentionRecord o) {
		return this.account.getAccountID().compareTo(o.account.getAccountID());
	}
	
	
	

}
