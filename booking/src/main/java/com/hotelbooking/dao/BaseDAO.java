package com.hotelbooking.dao;

import java.util.List;


public interface BaseDAO<T,ID> {
	
	void insertEntity(T entity);

	List<T> getAllEntities(Class<T> clazz);
	
	List<T> getByQuery(String query, String param) ;
	
	T getEntity(Class<?> clazz, ID id);
}
