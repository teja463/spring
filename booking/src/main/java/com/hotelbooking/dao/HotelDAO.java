package com.hotelbooking.dao;

import java.util.List;

import com.hotelbooking.model.Hotel;

public interface HotelDAO {

	public List<Hotel> showLeastPricedHotels(String city);
}
