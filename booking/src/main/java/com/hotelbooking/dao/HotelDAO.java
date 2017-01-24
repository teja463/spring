package com.hotelbooking.dao;

import java.util.List;

import com.hotelbooking.model.BookRoom;
import com.hotelbooking.model.Hotel;

public interface HotelDAO {

	public List<Hotel> showLeastPricedHotels(String city);
	
	public Hotel getHotel(String name);
	
	public int bookRoom(BookRoom bookRoom);
}
