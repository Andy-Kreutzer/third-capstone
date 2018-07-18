package com.techelevator.npgeek.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDAO;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDAO;

@Controller
public class ParkDetailsController {
	
	@Autowired
	private ParkDAO parkDao;
	
	@Autowired
	private WeatherDAO weatherDao;
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.GET)
	public String showDetails(HttpServletRequest request) {
		String parkCode = request.getParameter("parkCode");
		for(Park p : parkDao.getAllParks()) {
			if(p.getParkCode().equals(parkCode)) {
				request.setAttribute("park", p);
			}
		}
		
		for(Weather w : weatherDao.getWeather(parkCode)) {
			if (w.getParkCode().Equals(parkCode)) {
				request.setAttribute("weather", w);
			}
		}
		
		
	

		return "parkDetails";
	}
}
