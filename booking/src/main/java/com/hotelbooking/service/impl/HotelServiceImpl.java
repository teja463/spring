package com.hotelbooking.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotelbooking.dao.CityDAO;
import com.hotelbooking.dao.HotelDAO;
import com.hotelbooking.model.City;
import com.hotelbooking.model.Hotel;
import com.hotelbooking.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	private static final Log logger = LogFactory.getLog(HotelServiceImpl.class);

	@Autowired
	HotelDAO hotelDAO;
	
	@Autowired
	CityDAO cityDAO;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Hotel> showLeastPricedHotels(String city) {
		logger.info("[ENTRY]  showLeastPricedHotels()");
		logger.info("[EXIT] showLeastPricedHotels()");
		return hotelDAO.showLeastPricedHotels(city);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<City> getAllCities() {
		logger.info("[ENTRY]  getAllCities()");
		logger.info("[EXIT] getAllCities()");
		return cityDAO.getAllCities();
	}

}
