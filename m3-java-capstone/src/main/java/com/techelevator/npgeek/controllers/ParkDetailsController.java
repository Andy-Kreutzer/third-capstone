package com.techelevator.npgeek.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDAO;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDAO;

@Controller
@SessionAttributes("tempType")

public class ParkDetailsController {
	
	@Autowired
	private ParkDAO parkDao;

	@Autowired
	private WeatherDAO weatherDao;

	
	@RequestMapping(path="/parkDetails", method=RequestMethod.GET)
	public String showDetails(HttpServletRequest request, ModelMap map) {
	
		if (map.get("tempType") == null) {
			map.addAttribute("tempType", "F");
		}
		System.out.println(map.get("tempType"));
	    String parkCode = request.getParameter("parkCode");
	    List<Weather> parkForecast = new ArrayList<>();
	    parkForecast = weatherDao.getWeather(parkCode);
	   
	    if (map.get("tempType").equals("C")) {
	        for (int i = 0; i < 5; i++) {
	        	System.out.print("Here!");
	        	double newHigh = (parkForecast.get(i).getHigh() - 32);
	        	double newLow = (parkForecast.get(i).getLow() - 32);
	            parkForecast.get(i).setHigh((int) newHigh);
	            parkForecast.get(i).setLow((int) newLow);
	        }
	    }
	    
	    request.setAttribute("park", parkDao.getParkByCode(parkCode));
	    request.setAttribute("parkForecast", parkForecast);
	   
	    
	    return "parkDetails"; 
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.POST)
	public String changeTempType(@RequestParam(name="temp") String tempType, ModelMap map) {
		map.addAttribute("tempType", tempType);
		//return "parkDetails";   // Without bgClass as a SessionAttribute this page has the color, but no others
		return "redirect:/";    // Without bgClass as a SessionAttribute, a redirect loses our changes.  How does this change once we add the bgClass as a Session Attribute?
	}
}
