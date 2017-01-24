package com.hotelbooking.Validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hotelbooking.model.BookRoom;

public class BookRoomValidator implements Validator{

	private static final Log logger = LogFactory.getLog(BookRoomValidator.class);
	
	public boolean supports(Class<?> arg0) {
		return BookRoom.class.isAssignableFrom(arg0);
	}

	public void validate(Object obj, Errors errors) {
		logger.info("[ENTRY] validate()");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.city.required", "Please select a city");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hotel", "error.hotel.required", "Please select a hotel");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkIn", "error.checkIn.required", "Please select a valid date");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkOut", "error.checkOut.required", "Please select a valid date");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomsBooked", "error.roomsBooked.required", "Please enter number of rooms required");
		BookRoom booking = (BookRoom) obj;
		if(booking.getRoomsBooked() <= 0) {
			errors.rejectValue("roomsBooked", "zeroOrNegativeValue", "Please provide a valid value");
		}
		if(booking.getCheckOut() != null && booking.getCheckIn() != null && booking.getCheckOut().getTime() <= booking.getCheckIn().getTime()) {
			errors.rejectValue("checkOut", "error.invalid.checkOut", "The Checkout Date should be greater than the Checkin Date");
		}		
		
		logger.info("[EXIT] validate()");
	}

}
