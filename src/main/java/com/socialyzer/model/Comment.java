package com.socialyzer.model;

import java.util.Objects;

public class Comment implements Comparable<Comment> {
	private  int counter=0;
	private String commentId;
	private  Post post;
	private String comment;
	private float commentScore;
	
	{
		counter++;
		this.commentId= "C"+counter;
	}
	
	public Comment()
	{
		super();
	}

	public Comment(Post post, String comment, float commentScore) {
		super();
		this.post = post;
		this.comment = comment;
		this.commentScore = commentScore;
	}
	
	public Comment(String commentId,Post post, String comment, float commentScore) {
		super();
		this.commentId=commentId;
		this.post = post;
		this.comment = comment;
		this.commentScore = commentScore;
	}

	

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getCommentScore() {
		return commentScore;
	}

	public void setCommentScore(float commentScore) {
		this.commentScore = commentScore;
	}

	public int getCounter() {
		return counter;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(commentId, other.commentId);
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", post=" + post + ", comment=" + comment + ", commentScore="
				+ commentScore + "]";
	}

	@Override
	public int compareTo(Comment o) {
		return  this.commentId.compareTo(o.commentId);
	}
	
	
	

}
