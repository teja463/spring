package com.hotelbooking.service;

import java.util.List;

import com.hotelbooking.model.BookRoom;
import com.hotelbooking.model.City;
import com.hotelbooking.model.Hotel;

public interface HotelService {

	public List<Hotel> showLeastPricedHotels(String city, int limit);
	
	public List<City> getAllCities();
	
	public Hotel getHotel(String name);
	
	public int bookRoom(BookRoom bookRoom);
}
