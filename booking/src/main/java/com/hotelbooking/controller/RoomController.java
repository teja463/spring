package com.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomController {


	@RequestMapping(value="/bookRoom")
	public String bookRoom(Model model){
		
		return "hotels/bookRoom";
	}
}
