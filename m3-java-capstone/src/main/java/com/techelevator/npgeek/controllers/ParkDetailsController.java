package com.techelevator.npgeek.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class ParkDetailsController {
	
//	@Autowired
//	private ParksDao parkDao;
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.GET)
	public String showDetails() {
		return "parkDetails";
	}
}
