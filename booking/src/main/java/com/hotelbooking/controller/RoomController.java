package com.hotelbooking.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotelbooking.Validator.BookRoomValidator;
import com.hotelbooking.helper.BookRoomHelper;
import com.hotelbooking.model.BookRoom;
import com.hotelbooking.model.City;
import com.hotelbooking.model.Hotel;
import com.hotelbooking.service.HotelService;

@Controller
@RequestMapping(value="/room")
public class RoomController {
private static final Log logger = LogFactory.getLog(HotelController.class);
	
	@Autowired
	HotelService hotelService;

	@RequestMapping(value="/book")
	public ModelAndView bookRoom(){
		logger.info("[ENTRY] bookRoom()");
		
		List<City> cities = hotelService.getAllCities();
		ModelAndView model = new ModelAndView("hotels/bookRoom", "bookRoom", new BookRoom());
		model.addObject("cities",cities);
		
		logger.info("[EXIT] bookRoom()");
		return model;
	}
	
	@RequestMapping(value="/hotels")
	public String getHotels(@RequestParam("city") String city, Model model){
		logger.info("[ENTRY] getHotels()");
		List<Hotel> hotels = hotelService.showLeastPricedHotels(city, -1);
		model.addAttribute("hotels",hotels);
		logger.info("[EXIT] getHotels()");
		return "hotels/hotelDropDown";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public ModelAndView processBooking(@ModelAttribute("bookRoom") BookRoom bookRoom, BindingResult bindingResult){
		logger.info("[ENTRY] processBooking()");
		logger.info("recieved bookRoom : "+bookRoom);
		
		BookRoomValidator validator = new BookRoomValidator();
		if(validator.supports(BookRoom.class)){
			validator.validate(bookRoom, bindingResult);
			
		}
		
		Hotel hotel = hotelService.getHotel(bookRoom.getHotel());
		logger.info("[EXIT] processBooking()");
		boolean isBookingValid = true;
		if(null!=hotel){
			isBookingValid = BookRoomHelper.isBookingValid(bookRoom, hotel.getAvailableRooms());
		}
		logger.info("is booking valid : "+isBookingValid);
		if(bindingResult.hasErrors()||!isBookingValid){
			
			List<City> cities = hotelService.getAllCities();
			ModelAndView modelBookRoom = new ModelAndView("hotels/bookRoom", "bookRoom", bookRoom);
			modelBookRoom.addObject("cities",cities);
			if(!isBookingValid){
				bindingResult.rejectValue("roomsBooked", "max.rooms.error");
			}
			return modelBookRoom;
		}else{
			int days = (int) (bookRoom.getCheckOut().getTime()- bookRoom.getCheckIn().getTime())/(1000 * 60 * 60 * 24);
			double cost = Double.valueOf(hotel.getRoomPrice()*days*bookRoom.getRoomsBooked());
			bookRoom.setTotalCost(cost);
			int status = hotelService.bookRoom(bookRoom);
			ModelAndView model = new ModelAndView("hotels/bookingResult", "bookRoom", bookRoom);
			if(status==0){
				model.addObject("status", "Success");
				model.addObject("message", "You have successfully booked "+ bookRoom.getRoomsBooked()+" rooms at "+ bookRoom.getHotel() +" in "+bookRoom.getCity() + " for "+ days +" days. "+" You need to pay "+cost +" Rs.");
			}else{
				model.addObject("status", "Fail");
				model.addObject("message", "We can not book the "+ bookRoom.getRoomsBooked()+" rooms at "+ bookRoom.getHotel() +" in "+bookRoom.getCity() + " for "+ days +" days");
			}
			return model;
		}
		
		
	}
}
