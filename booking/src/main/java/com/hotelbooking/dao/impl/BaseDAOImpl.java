package com.hotelbooking.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hotelbooking.dao.BaseDAO;

@Repository
public class BaseDAOImpl<T,ID> implements BaseDAO<T,ID>{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void insertEntity(T entity) {
		hibernateTemplate.save(entity);
		
	}

	public List<T> getAllEntities(Class<T> clazz) {
		return hibernateTemplate.loadAll(clazz);
	}

	@SuppressWarnings("unchecked")
	public List<T> getByQuery(String query, String param) {
		return (List<T>) hibernateTemplate.find(query, param);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getByQueryMulitpleParameter(String query, String ...strings){
		return (List<T>)hibernateTemplate.find(query, strings);
	}

	public T getEntity(Class<?> clazz, ID id) {
		return null;
	}

}
