package com.techelevator.npgeek.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.npgeek.model.park.ParkDAO;

@Controller
public class HomeController {
	
	@Autowired
	private ParkDAO parkDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHome(HttpServletRequest request) {
		request.setAttribute("allParks", parkDao.getAllParks());
		return "homePage";
	}
	
	
}
