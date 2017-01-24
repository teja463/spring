package com.hotelbooking.helper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hotelbooking.model.BookRoom;

public class BookRoomHelper {

	private static final Log logger = LogFactory.getLog(BookRoomHelper.class);
	
	public static boolean  isBookingValid(BookRoom bookRoom, int totalRooms) {
		logger.info("bookRoom.getRoomsBooked() >  totalRooms: "+ (totalRooms >= bookRoom.getRoomsBooked()));
		return totalRooms >= bookRoom.getRoomsBooked();
	}
}
