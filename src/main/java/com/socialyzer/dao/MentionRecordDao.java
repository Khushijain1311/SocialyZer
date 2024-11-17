package com.socialyzer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.socialyzer.model.Account;
import com.socialyzer.model.MentionRecord;
import com.socialyzer.util.DBConnection;

public class MentionRecordDao  implements IDao<MentionRecord>{
	
	Connection connection;
	ArrayList<MentionRecord> mentionRecordList= new ArrayList();
	DBConnection dbConnection;
	
	public MentionRecordDao(DBConnection dbConnection)
	{
		this.dbConnection= dbConnection;
		
	}

	@Override
	public MentionRecord findOne(String id) throws Exception {
		return null;
	}
	
	public MentionRecord insert(MentionRecord mentionRecord) throws Exception
	{
			connection =dbConnection.getConnection();
			String sqlQuery= "insert into mention_records (account_id, no_of_mentions, timestp) values (?,?,?)";
			PreparedStatement preparedStatement =connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, mentionRecord.getAccount().getAccountID());
			preparedStatement.setInt(2,  mentionRecord.getNoOfMentions());
			preparedStatement.setTimestamp(3, Timestamp.valueOf(mentionRecord.getTimestamp()));
			
			if(preparedStatement.executeUpdate()<0)
				return null;
		return mentionRecord;
	}
	
	public ArrayList<MentionRecord> findAllMentionRecord(String accountId) throws Exception
	{
		connection=dbConnection.getConnection();
		String sqlQuery= "select * from mention_records where account_id=?";
		PreparedStatement preparedStatement= connection.prepareStatement(sqlQuery);
		
		preparedStatement.setString(1, accountId);
		ResultSet resultSet= preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			
		MentionRecord mentionRecord= new MentionRecord();
		Account account= new Account();
		account.setAccountID(accountId);
		mentionRecord.setAccount(account);
		mentionRecord.setNoOfMentions(resultSet.getInt("no_of_mentions"));
		mentionRecord.setTimestamp(resultSet.getTimestamp("timestp").toLocalDateTime());
		
		mentionRecordList.add(mentionRecord);
		
		}
		
		return mentionRecordList;
		
	}
	
	public boolean delete(String accountId) throws Exception
	{
		return false;
	}
	
	public boolean update(String accountId) throws Exception
	{
		return false;
	}
	

}
