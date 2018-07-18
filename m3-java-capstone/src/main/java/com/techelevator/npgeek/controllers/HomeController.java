package com.techelevator.npgeek.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
