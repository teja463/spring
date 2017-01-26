package com.hotelbooking.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hotelbooking.dao.HotelDAO;
import com.hotelbooking.exception.HotelBookingException;
import com.hotelbooking.model.BookRoom;
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

	public Hotel getHotel(String name) {
		logger.info("[ENTRY] getHotel()");
		logger.info("hotel name received: "+name);
		List<Hotel> hotels = (List<Hotel>)(List)hibernateTemplate.find("from Hotel where name=? ", name);
		Hotel hotel = null;
		if(null!=hotels&&hotels.size()>0){
			hotel = hotels.get(0);
		}
		logger.info("[EXIT] showLeastPricedHotels()");
		return hotel;
	}

	public int bookRoom(BookRoom bookRoom) {
		try{
			Serializable status = hibernateTemplate.save(bookRoom);
			logger.info("status : "+status);
		}catch(HotelBookingException hbe){
			hbe.printStackTrace();
		}
		return 0;
	}

	public int isRoomAvailable(BookRoom bookRoom) {
		Date from = bookRoom.getCheckIn();
		Date to = bookRoom.getCheckOut();
		java.sql.Date fromDateSql = new java.sql.Date(from.getTime());
		java.sql.Date toDateSql = new java.sql.Date(to.getTime());
		List<BookRoom> bookedRooms = null;

		bookedRooms  = (List<BookRoom>)(List)hibernateTemplate.find("from BookRoom where HOTEL= ? AND (CHECKIN <= ? AND CHECKOUT >= ?)", bookRoom.getHotel(), toDateSql.toString(), fromDateSql.toString());
		logger.info("bookedRooms list : "+bookedRooms);
		int roomsBooked=0;
		if(null!=bookedRooms){
			
			for(BookRoom bookedRoom :bookedRooms){
				roomsBooked+=bookedRoom.getRoomsBooked();
			}
		}
		return roomsBooked;
	}

	

}
