package com.hotelbooking.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotelbooking.model.City;
import com.hotelbooking.model.Hotel;
import com.hotelbooking.service.HotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {

	private static final Log logger = LogFactory.getLog(HotelController.class);
	
	@Autowired
	HotelService hotelService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showLeastPricedHotels(Model model){
		logger.info("[ENTRY] showLeastPricedHotels()");
		
		List<City> cities = hotelService.getAllCities();
		logger.info("cities received from dao : "+cities);
		
		model.addAttribute("cities", cities);
		logger.info("[EXIT] showLeastPricedHotels()");
		return "hotels/hotels";
	}
	
	@RequestMapping(value="/list")
	public String getListOfHotels( @RequestParam("city") String city, Model model ){
		List<Hotel> hotels = hotelService.showLeastPricedHotels(city,5);
		logger.info("hotels received from dao : "+hotels);
		model.addAttribute("hotels",hotels);
		return "hotels/hotelList";
	}
	
	
}
