package com.hotelbooking.helper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotelbooking.model.BookRoom;
import com.hotelbooking.service.HotelService;

public class BookRoomHelper {

	@Autowired
	HotelService hotelService;
	
	private static final Log logger = LogFactory.getLog(BookRoomHelper.class);
	
	
}
