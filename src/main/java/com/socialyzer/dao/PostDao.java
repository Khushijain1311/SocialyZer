package com.socialyzer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.socialyzer.model.Account;
import com.socialyzer.model.Post;
import com.socialyzer.util.DBConnection;

public class PostDao  implements IDao<Post>{
	
	Connection connection;
	DBConnection dbConnection;
	ArrayList<Post> postList= new ArrayList();
	
	public PostDao(DBConnection dbConnection)
	{
		this.dbConnection= dbConnection;
	}
	
	public Post insert(Post post) throws Exception
	{
		connection= dbConnection.getConnection();
		String sqlQuery="insert into posts ( account_id, post_text, like_count, share_count, post_time, post_score) values(?,?,?,?,?,?)";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, post.getAccount().getAccountID());
		preparedStatement.setString(2, post.getPostText());
		preparedStatement.setInt(3, post.getLikeCount());
		preparedStatement.setInt(4, post.getShareCount());
		preparedStatement.setTimestamp(5, Timestamp.valueOf(post.getPostTime()));
		preparedStatement.setFloat(6,  post.getPostScore());
		
		if(preparedStatement.executeUpdate()<0)
			return null;
		
		return post;
	}

	
	public boolean update(Post post) throws Exception
	{	connection =dbConnection.getConnection();
		String sqlQuery= "update Posts set  like_count=?, share_count=? where post_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1,  post.getLikeCount());
		preparedStatement.setInt(2,post.getShareCount());
		preparedStatement.setString(3, post.getPostId());
		
		if(preparedStatement.executeUpdate()<0)
			return false;
		
		return true;
	}
	
	
	public boolean delete(String postId) throws Exception
	{	
		connection=dbConnection.getConnection();
		String sqlQuery="delete from posts where post_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,  postId);
		if(preparedStatement.executeUpdate()<0)
			return false;
		return true;
	}
	@Override
	public Post findOne(String id) throws Exception {
		
		connection=dbConnection.getConnection();
		String sqlQuery="select * from posts where post_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, id);
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) { 
			Post post= new Post();
			String accountId=resultSet.getString("account_id");
			String postText= resultSet.getString("post_text");
			int likeCount=resultSet.getInt("like_count");
			int shareCount= resultSet.getInt("share_count");
			LocalDateTime timestamp = resultSet.getTimestamp("post_time").toLocalDateTime();
			float postScore = resultSet.getFloat("post_score");
			
			post.setPostId(id);
			Account account= new Account();
			account.setAccountID(accountId);
			post.setAccount(account);
			post.setLikeCount(likeCount);
			post.setShareCount(shareCount);
			post.setPostTime(timestamp);
			post.setPostScore(postScore);
			
			
			return post;
			
		}
		return null;
	}
	
	public ArrayList<Post> findAllPost() throws Exception
	{
		connection=dbConnection.getConnection();
		String sqlQuery= "select  * from posts";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		ResultSet resultSet= preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			
			Post post= new Post();
			String accountId=resultSet.getString("account_id");
			String postText= resultSet.getString("post_text");
			int likeCount=resultSet.getInt("like_count");
			int shareCount= resultSet.getInt("share_count");
			LocalDateTime timestamp = resultSet.getTimestamp("post_time").toLocalDateTime();
			float postScore = resultSet.getFloat("post_score");
			
			post.setPostId(resultSet.getString("post_id"));
			Account account= new Account();
			account.setAccountID(accountId);
			post.setAccount(account);
			post.setLikeCount(likeCount);
			post.setShareCount(shareCount);
			post.setPostTime(timestamp);
			post.setPostScore(postScore);
			postList.add(post);
			
			
		}
		return postList;
	}
	
	public ArrayList<Post> findAllPostById(String accountid) throws Exception
	{
		connection=dbConnection.getConnection();
		String sqlQuery= "select  * from posts where account_id=?";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, accountid);
		ResultSet resultSet= preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			
			Post post= new Post();
			String accountId=resultSet.getString("account_id");
			String postText= resultSet.getString("post_text");
			int likeCount=resultSet.getInt("like_count");
			int shareCount= resultSet.getInt("share_count");
			LocalDateTime timestamp = resultSet.getTimestamp("post_time").toLocalDateTime();
			float postScore = resultSet.getFloat("post_score");
			
			post.setPostId(resultSet.getString("post_id"));
			Account account= new Account();
			account.setAccountID(accountId);
			post.setAccount(account);
			post.setLikeCount(likeCount);
			post.setShareCount(shareCount);
			post.setPostTime(timestamp);
			post.setPostScore(postScore);
			postList.add(post);
			
			
		}
		return postList;
	}
	
	
	
	

}
