package com.socialyzer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.socialyzer.model.Account;
import com.socialyzer.model.Competitor;
import com.socialyzer.util.DBConnection;

public class CompetitorDao implements IDao<Competitor> {
	private DBConnection dbConnection;
	private ArrayList<Competitor> competitorList= new ArrayList();
	private Connection connection;
	public CompetitorDao(DBConnection dbConnection)
	{
		this.dbConnection= dbConnection;
	}
	
	public Competitor insert(Competitor competitor)  throws Exception
	{
		connection=dbConnection.getConnection();
		String sqlQuery="insert into competitors(account_id, competitor_id) values(?,?)";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1,competitor.getAccount().getAccountID());
		preparedStatement.setString(2,  competitor.getCompetitor().getAccountID());
		
		if(preparedStatement.executeUpdate()<0)
			return null;
		
		return competitor;
	}
	
	public boolean delete(String id) throws Exception
	{
			connection= dbConnection.getConnection();
			String sqlQuery="delete from competitors where account_id=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, id);
			if(preparedStatement.executeUpdate()<0)
				return false;
		return true;
		
	}
	
	
	public ArrayList<Competitor> findAllCompetitorById(String id) throws Exception
	{
		connection= dbConnection.getConnection();
		
		String sqlQuery="select * from Competitors where account_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, id);
		ResultSet resultSet= preparedStatement.executeQuery();
		while(resultSet.next())
		{
			String accountId= resultSet.getString("account_id");
			String competitorId= resultSet.getString("competitor_id");
			Account account=new Account();
			account.setAccountID(accountId);
			Account competitor = new Account();
			competitor.setAccountID(competitorId);
			Competitor competitorData= new Competitor(account, competitor);
			competitorList.add(competitorData);
			
			
		}
		
		return competitorList;
	}

	@Override
	public Competitor findOne(String id) throws Exception {
		return null;
	}
	

}
