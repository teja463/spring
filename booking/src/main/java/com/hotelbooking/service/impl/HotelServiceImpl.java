package com.hotelbooking.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotelbooking.dao.CityDAO;
import com.hotelbooking.dao.HotelDAO;
import com.hotelbooking.model.BookRoom;
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
	public List<Hotel> showLeastPricedHotels(String city, int limit) {
		logger.info("[ENTRY]  showLeastPricedHotels()");
		List<Hotel> hotels=hotelDAO.showLeastPricedHotels(city);
		logger.info("[EXIT] showLeastPricedHotels()");
		if(limit==-1){
			return hotels;
		}else if(null!=hotels&&hotels.size()>limit){
			return hotels.subList(0, limit);
		}else{
			return hotels;
		}
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<City> getAllCities() {
		logger.info("[ENTRY]  getAllCities()");
		logger.info("[EXIT] getAllCities()");
		List<City> allCities = cityDAO.getAllCities();
		Collections.sort(allCities, new Comparator<City>() {
            public int compare(City lhs, City rhs) {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
		return allCities;
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Hotel getHotel(String name){
		return hotelDAO.getHotel(name);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int bookRoom(BookRoom bookRoom) {
		return hotelDAO.bookRoom(bookRoom);
	}

	public int isRoomAvailable(BookRoom bookRoom) {
		int roosBooked = hotelDAO.isRoomAvailable(bookRoom);
		logger.info("number of rooms booked : "+roosBooked);
		return roosBooked;
	}
}
