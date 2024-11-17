package com.socialyzer.model;

import java.util.Objects;

public class Mention  implements Comparable<Mention>{
	private Post post;
	private Account account;
	public Mention()
	{
		super();
	}
	
	public Mention(Post post, Account account) {
		super();
		this.post = post;
		this.account = account;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public int hashCode() {
		return Objects.hash(account, post);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mention other = (Mention) obj;
		return Objects.equals(account, other.account) && Objects.equals(post, other.post);
	}
	@Override
	public String toString() {
		return "Mention [post=" + post + ", account=" + account + "]";
	}
	@Override
	public int compareTo(Mention o) {
		return this.post.getPostId().compareTo(o.post.getPostId());
	}
	
	

}
