//package com.training.socialyzer.dao;
package com.socialyzer.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.socialyzer.model.User;
import  com.socialyzer.util.*; 

public class UserDao implements IDao<User> {
	
	private DBConnection dbConnection;
	private ArrayList<User> userList= new ArrayList();
	private Connection connection;
	
	public UserDao(DBConnection dbConnection)
	{
		this.dbConnection= dbConnection;
		
	}
	
	public User insert(User user) throws Exception
	{
		connection=dbConnection.getConnection();
		String sqlQuery="insert into users(email, password) values(?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2,  user.getPassword());
		
		if(preparedStatement.executeUpdate()<0)
		return null;
		return user;
	}
	
	
	@Override
	public User findOne(String id) throws Exception {
		connection = dbConnection.getConnection();
		String sqlQuery="select * from users where email=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,id);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		if(resultSet.next()) {
			String email= resultSet.getString("email");
			String password= resultSet.getString("password");
			User user= new User(email, password);
			return user;
		}
		
		
		return null;
	}
	
	
	public boolean update(String id, User user) throws Exception
	{
		connection= dbConnection.getConnection();
		String sqlQuery="update users set password=? where email=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, user.getPassword());
		preparedStatement.setString(2, id);//id==email
		
		if(preparedStatement.executeUpdate()<0)
		{
			return false;
		}
		return true;
		
	}
	
	
	public boolean delete(String id) throws Exception
	{
		connection=dbConnection.getConnection();
		String sqlQuery= "delete from users where email=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,id);
		
		if(preparedStatement.executeUpdate()<0)
		{
			return false;
		}
		
		return true;
	}
	
	public ArrayList<User> findAll() throws Exception
	{
		connection =dbConnection.getConnection();
		String sqlQuery="select * from users";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			String email=resultSet.getString("email");
			String password=resultSet.getString("password");
			User user= new User(email, password);
			userList.add(user);
		}
		return userList;
		
	}
	
	

}
