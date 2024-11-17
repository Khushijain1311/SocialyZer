package com.socialyzer.dao;
import com.socialyzer.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.socialyzer.model.Account;
import com.socialyzer.model.Facebook;
import com.socialyzer.model.Instagram;
import com.socialyzer.model.SocialMedia;
import com.socialyzer.model.Twitter;
import com.socialyzer.model.User;
public class AccountDao implements IDao<Account>{
	private DBConnection dbConnection;
	private ArrayList<Account> accountList= new ArrayList();
	private Connection connection;
	
	public AccountDao()
	{
		super();
	}
	
	public AccountDao(DBConnection dbConnection)
	{
		this.dbConnection= dbConnection;
	}
	

	public Account insert(Account account) throws Exception {
		connection=dbConnection.getConnection();
		//String sqlQuery="insert into Accounts values ( account_id, platform, username, email, followers_count, date_joined, account_url)"
		//		+ " values (?,?,?,?,?,?,?)";
		
		String sqlQuery = "INSERT INTO Accounts ( platform, username, email, followers_count, date_joined, account_url) "
                + "VALUES ( ?, ?, ?, ?, ?, ?)";

		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,account.getSocialMedia().getPlatform());
		preparedStatement.setString(2, account.getSocialMedia().getUsername());
		preparedStatement.setString(3, account.getUser().getEmail());
		preparedStatement.setInt(4,account.getSocialMedia().getFollowerCount());
		Timestamp timeStamp= Timestamp.valueOf(account.getDateJoined());
		preparedStatement.setTimestamp(5,timeStamp);
		preparedStatement.setString(6,  account.getSocialMedia().getUrl());
		
		if(preparedStatement.executeUpdate()<0)
			return null;
		
		
		return account;
	}

	
	public boolean update(String  id,Account account ) throws Exception {
		connection=dbConnection.getConnection();
		String sqlQuery="update Accounts set username=?,email=?, followers_count=?  where account_id=?" ;
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, account.getSocialMedia().getUsername());
		preparedStatement.setString(2, account.getUser().getEmail());
		preparedStatement.setInt(3, account.getSocialMedia().getFollowerCount());
		preparedStatement.setString(4,  id);
		
		if(preparedStatement.executeUpdate()<0)
		{
			return false;
		}
		return  true;
	}

	
	public boolean delete(String  id) throws Exception {
		connection=dbConnection.getConnection();
		String sqlQuery="delete from accounts where account_id=?";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, id);
		if(preparedStatement.executeUpdate()<0)
		return false;
		
		return true;
	}

	
	

	
	public ArrayList<Account> findAll() throws Exception {
		connection=dbConnection.getConnection();
		String sqlQuery="select * from accounts";
		
		PreparedStatement prepareStatement= connection.prepareStatement(sqlQuery);
		ResultSet resultSet= prepareStatement.executeQuery();
		
		while(resultSet.next())
		{
			String accountId= resultSet.getString("account_id");
			String platform =resultSet.getString("platform");
			String userName= resultSet.getString("username");
			String email= resultSet.getString("email");
			int followerCount=resultSet.getInt("followers_count");
			Timestamp timeStamp= resultSet.getTimestamp("date_joined");
			String accountUrl= resultSet.getString("account_url");
			SocialMedia socialMedia;
			
			if(platform.equalsIgnoreCase("Instagram"))
			{
				socialMedia= new Instagram(userName,accountUrl, followerCount);
			}
			else if(platform.equalsIgnoreCase("Twitter"))
			{
				socialMedia= new Twitter(userName, accountUrl, followerCount);
			}
			else
			{
				socialMedia= new Facebook(userName, accountUrl, followerCount);
			}
			User user = new User(email, null);
			Account account= new Account(socialMedia, accountId,user,timeStamp.toLocalDateTime());
			accountList.add(account);
		}
		return accountList;
	}

	@Override
	public Account findOne(String id) throws Exception {
		connection= dbConnection.getConnection();
		String sqlQuery="select * from accounts where account_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,id);
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) {
			
			String accountId= resultSet.getString("account_id");
			String platform =resultSet.getString("platform");
			String userName= resultSet.getString("username");
			String email= resultSet.getString("email");
			int followerCount=resultSet.getInt("followers_count");
			Timestamp timeStamp= resultSet.getTimestamp("date_joined");
			String accountUrl= resultSet.getString("account_url");
			SocialMedia socialMedia;
			
			if(platform.equalsIgnoreCase("Instagram"))
			{
				socialMedia= new Instagram(userName,accountUrl, followerCount);
			}
			else if(platform.equalsIgnoreCase("Twitter"))
			{
				socialMedia= new Twitter(userName, accountUrl, followerCount);
			}
			else
			{
				socialMedia= new Facebook(userName, accountUrl, followerCount);
			}
			User user = new User(email, null);
			Account account= new Account(socialMedia, accountId,user,timeStamp.toLocalDateTime());
			return account;
			
		}
		
		return null;
	}
	
	public ArrayList<Account> findByEmail(String email) throws Exception
	{
		connection= dbConnection.getConnection();
		String sqlQuery="select * from accounts where email=?";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, email);
		ResultSet resultSet= preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			String accountId= resultSet.getString("account_id");
			String platform =resultSet.getString("platform");
			String userName= resultSet.getString("username");
			String emailInput= resultSet.getString("email");
			int followerCount=resultSet.getInt("followers_count");
			Timestamp timeStamp= resultSet.getTimestamp("date_joined");
			String accountUrl= resultSet.getString("account_url");
			SocialMedia socialMedia;
			
			if(platform.equalsIgnoreCase("Instagram"))
			{
				socialMedia= new Instagram(userName,accountUrl, followerCount);
			}
			else if(platform.equalsIgnoreCase("Twitter"))
			{
				socialMedia= new Twitter(userName, accountUrl, followerCount);
			}
			else
			{
				socialMedia= new Facebook(userName, accountUrl, followerCount);
			}
			User user = new User(emailInput, null);
			Account account= new Account(socialMedia, accountId,user,timeStamp.toLocalDateTime());
			
			accountList.add(account);
		}
		
		return accountList;
	}

}
