package com.socialyzer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.socialyzer.model.Account;
import com.socialyzer.model.Follower;
import com.socialyzer.util.DBConnection;

public class FollowerDao implements IDao<Follower>{
	Connection connection;
	DBConnection dbConnection;
	ArrayList<Follower> followerList= new ArrayList();
	public FollowerDao(DBConnection dbConnection)
	{
		this.dbConnection=dbConnection;
	}
	
	public  Follower insert(Follower follower) throws Exception
	{
			connection =dbConnection.getConnection();
			String sqlQuery= "insert into followers (account_id, followers_count, timestp) values (?,?,?)";
			PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, follower.getAccount().getAccountID());
			preparedStatement.setInt(2,follower.getFollowerCount());
			preparedStatement.setTimestamp(3, Timestamp.valueOf(follower.getTimeStp()));
			
			if(preparedStatement.executeUpdate()<0)
				return null;
			return follower;
	}
	
	
	public boolean delete(String accountId) throws Exception
	{	connection=dbConnection.getConnection();
		String sqlQuery="delete from followers where account_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, accountId);
		if(preparedStatement.executeUpdate()<0)
			return false;
		
		return true;
	}
	
	
	public boolean update(Follower follower) throws Exception
	{
			connection =dbConnection.getConnection();
			String sqlQuery= "update followers set followers_count=?, timestp=? where account_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, follower.getFollowerCount());
			preparedStatement.setTimestamp(2,Timestamp.valueOf(follower.getTimeStp()));
			preparedStatement.setString(3, follower.getAccount().getAccountID());
			if(preparedStatement.executeUpdate()<0)
				return false;
			return true;
	}
	public ArrayList<Follower> findAllById(String id) throws Exception
	{
			connection= dbConnection.getConnection();
			String sqlQuery="select * from followers where account_id=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, id);
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				String accountId= resultSet.getString("account_id");
				int followerCount= resultSet.getInt("followers_count");
				Timestamp timeStamp= resultSet.getTimestamp("timeStp");
				Account account= new Account();
				account.setAccountID(accountId);
				Follower follower= new Follower(account,followerCount, timeStamp.toLocalDateTime());
				followerList.add(follower);
				
			}
		return followerList;
	}
	
	public ArrayList<Follower> findAll() throws Exception
	{
		connection=dbConnection.getConnection();
		String sqlQuery= "select * from followers";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		ResultSet resultSet= preparedStatement.executeQuery();
		while(resultSet.next()) {
			String accountId= resultSet.getString("account_id");
			int followerCount= resultSet.getInt("followers_count");
			Timestamp timeStamp= resultSet.getTimestamp("timeStp");
			Account account= new Account();
			account.setAccountID(accountId);
			Follower follower= new Follower(account,followerCount, timeStamp.toLocalDateTime());
			followerList.add(follower);
		}
		return followerList;
	}

	@Override
	public Follower findOne(String id) throws Exception {
		return null;
	}
	
	
	
	
	

}
