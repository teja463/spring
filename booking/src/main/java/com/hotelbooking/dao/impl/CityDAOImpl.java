package com.hotelbooking.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hotelbooking.dao.CityDAO;
import com.hotelbooking.model.City;

@Repository
public class CityDAOImpl implements CityDAO {

	private static final Log logger = LogFactory.getLog(CityDAOImpl.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<City> getAllCities() {
		logger.info("[ENTRY] getAllCities()");
		logger.info("[EXIT] getAllCities()");
		return hibernateTemplate.loadAll(City.class);
	}
}
