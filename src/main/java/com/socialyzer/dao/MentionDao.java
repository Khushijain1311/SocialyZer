package com.socialyzer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.socialyzer.model.Account;
import com.socialyzer.model.Mention;
import com.socialyzer.model.Post;
import com.socialyzer.util.DBConnection;

public class MentionDao implements IDao<Mention> {
	Connection connection;
	ArrayList<Mention>  mentionList= new ArrayList();
	DBConnection dbConnection;
	
	public MentionDao(DBConnection dbConnection)
	{
		this.dbConnection =dbConnection;
	}
	
	public Mention insert(Mention mention) throws Exception
	{
		connection=dbConnection.getConnection();
		String sqlQuery="insert into mentions (post_id, mentioned_id) values(?,?)";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,mention.getPost().getPostId());
		preparedStatement.setString(2, mention.getAccount().getAccountID());
		
		if(preparedStatement.executeUpdate()<0)
			return null;
		
		return mention;
	}
	
	public Mention findOne(String id) throws Exception
	{
		return null;
	}
	
	public boolean update(String id)
	{
		return false;
	}
	
	public boolean delete(String id)
	{
		return false;
	}
	
	public ArrayList<Mention> findAllMention(String postId) throws Exception
	{	
		connection=dbConnection.getConnection();
		String sqlQuery="select * from mentions where post_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, postId);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		while(resultSet.next()) {
			String postIdData= resultSet.getString("post_id");
			String mentionData= resultSet.getString("mentioned_id");
			Post post= new Post();
			post.setPostId(postIdData);
			Account mentioned= new Account();
			mentioned.setAccountID(mentionData);
			Mention mentionRecord= new Mention(post, mentioned);
			mentionList.add(mentionRecord);
		}
		
		return mentionList;
	}

}
