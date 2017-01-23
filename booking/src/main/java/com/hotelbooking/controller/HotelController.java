package com.hotelbooking.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotelbooking.service.HotelService;

@Controller
public class HotelController {

	private static final Log logger = LogFactory.getLog(HotelController.class);
	
	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value="/hotels")
	public String showLeastPricedHotels( @RequestParam("city") String city){
		logger.info("[ENTRY] showLeastPricedHotels()");
		logger.info("city received: "+city); 
		hotelService.showLeastPricedHotels(city);
		logger.info("[EXIT] showLeastPricedHotels()");
		return "hotels/hotels";
	}
}
