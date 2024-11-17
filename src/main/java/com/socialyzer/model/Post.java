package com.socialyzer.model;
import java.time.LocalDateTime;
import java.util.Objects;

public class Post  implements Comparable<Post>{
	private static int counter=0;
	private String postId;
	private Account account;
	private String  postText;
	private int likeCount;
	private int shareCount;
	private LocalDateTime postTime;
	private float postScore;
	
	{
		counter++;
		this.postId="p"+counter;
	}
	
	public Post()
	{
		super();
	}

	public Post(Account account, String postText, int likeCount, int shareCount, LocalDateTime postTime,
			float postScore) {
		super();
		this.account = account;
		this.postText = postText;
		this.likeCount = likeCount;
		this.shareCount = shareCount;
		this.postTime = postTime;
		this.postScore = postScore;
	}
	
	

	public Post(String postText, int likeCount, int shareCount) {
		super();
		this.postText = postText;
		this.likeCount = likeCount;
		this.shareCount = shareCount;
	}
	

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getShareCount() {
		return shareCount;
	}

	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}

	public LocalDateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

	public float getPostScore() {
		return postScore;
	}

	public void setPostScore(float postScore) {
		this.postScore = postScore;
	}

	public static int getCounter() {
		return counter;
	}

	@Override
	public int hashCode() {
		return Objects.hash(postId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(postId, other.postId);
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", account=" + account + ", postText=" + postText + ", likeCount=" + likeCount
				+ ", shareCount=" + shareCount + ", postTime=" + postTime + ", postScore=" + postScore + "]";
	}

	@Override
	public int compareTo(Post o) {
		return this.postId.compareTo(o.postId);
	}
	
	
	

}
