package com.hotelbooking.service;

import java.util.List;

import com.hotelbooking.model.Hotel;

public interface HotelService {

	public List<Hotel> showLeastPricedHotels(String city);
}
