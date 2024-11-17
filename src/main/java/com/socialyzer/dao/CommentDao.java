package com.socialyzer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.socialyzer.model.Comment;
import com.socialyzer.model.Post;
import com.socialyzer.util.DBConnection;

public class CommentDao implements IDao<Comment> {
	
	private DBConnection dbConnection;
	private ArrayList<Comment> commentList= new ArrayList();
	private Connection connection;
	
	public CommentDao(DBConnection dbConnection)
	{
		this.dbConnection= dbConnection;
	}
	
	public Comment insert(Comment comment) throws Exception
	{	
		connection=dbConnection.getConnection();
		String sqlQuery="insert into comments ( post_id, comment_text,comment_score) values(?,?,?)";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1,  comment.getPost().getPostId());
		preparedStatement.setString(2,  comment.getComment());
		preparedStatement.setFloat(3, comment.getCommentScore());
		
		if(preparedStatement.executeUpdate()<0)
			return null;
		
		
		return comment;
	}
	
	public boolean delete(String commentId) throws Exception
	{
		connection= dbConnection.getConnection();
		String sqlQuery= "delete from comments where comment_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,  commentId);
		if(preparedStatement.executeUpdate()<0)
		{
			return false;
		}
		return true;
	}
	
	public ArrayList<Comment> findAllCommentByPost(String postId) throws Exception
	{	connection =dbConnection.getConnection();
		String sqlQuery="select comment_id, comment_text, comment_score from comments where post_Id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, postId);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			String commentId=resultSet.getString("comment_id");
			String commentText= resultSet.getString("comment_text");
			float commentScore=resultSet.getFloat("comment_score");
			Post post= new Post();
			post.setPostId(postId);
			Comment comment=new Comment(commentId, post, commentText, commentScore);
			commentList.add(comment);
			
		}
		

		
		return commentList;
	}
	
	
	public Comment findOne(String id) throws Exception
	{
		connection =dbConnection.getConnection();
		String sqlQuery="select * from comments where comment_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,id);
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) {
			
			String commentId=resultSet.getString("comment_id");
			String postId= resultSet.getString("post_id");
			String commentText= resultSet.getString("comment_text");
			float commentScore=resultSet.getFloat("comment_score");
			Post post= new Post();
			post.setPostId(postId);
			Comment comment=new Comment(commentId, post, commentText, commentScore);
			return comment;
			
			
		}
		else
		return null;
	}
	
	
	public boolean update(String commentId) throws Exception
	{
		return true;
	}
	
	
	
	
	

}
