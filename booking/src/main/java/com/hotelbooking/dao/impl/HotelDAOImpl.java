package com.hotelbooking.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hotelbooking.dao.HotelDAO;
import com.hotelbooking.model.Hotel;

@Repository
public class HotelDAOImpl implements HotelDAO{
	
	private static final Log logger = LogFactory.getLog(HotelDAOImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Hotel> showLeastPricedHotels(String city) {
		logger.info("[ENTRY] showLeastPricedHotels()");
		logger.info("city received: "+city);
		List<Hotel> hotels = (List<Hotel>)(List)hibernateTemplate.find("from Hotel where CITY=? order by ROOM_PRICE asc", city);
		logger.info("[EXIT] showLeastPricedHotels()");
		return hotels;
	}


}
