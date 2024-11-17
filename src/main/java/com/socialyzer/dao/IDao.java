package com.socialyzer.dao;
import java.util.ArrayList;

public interface IDao<T> {
	//T insert(T t) throws Exception;
	//boolean update(String id, T t) throws Exception;
//	boolean delete(String id) throws Exception;
	T findOne(String id) throws Exception;
//	ArrayList<T> findAll() throws Exception;

}
