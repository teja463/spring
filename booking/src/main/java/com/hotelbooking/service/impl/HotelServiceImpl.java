package com.hotelbooking.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotelbooking.dao.HotelDAO;
import com.hotelbooking.model.Hotel;
import com.hotelbooking.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	private static final Log logger = LogFactory.getLog(HotelServiceImpl.class);

	@Autowired
	HotelDAO hotelDAO;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Hotel> showLeastPricedHotels(String city) {
		logger.info("[ENTRY] service : showLeastPricedHotels()");
		hotelDAO.showLeastPricedHotels(city);
		logger.info("[EXIT] service : showLeastPricedHotels()");
		return null;
	}

}
