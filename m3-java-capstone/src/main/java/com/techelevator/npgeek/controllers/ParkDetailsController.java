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
	public String showDetails(HttpServletRequest request, @RequestParam(name="tempType") String tempType, ModelMap map) {
		map.addAttribute("tempType", tempType);
		
		String parkCode = request.getParameter("parkCode");
		ArrayList<Weather> parkForecast = new ArrayList<>();
		parkForecast =  (ArrayList<Weather>) weatherDao.getWeather(parkCode);
		
		String[] suggestions = {"", "", "", "", ""};
		String[] temperatureSuggestions = {"", "", "", "", ""};
		
		for (int i=0; i < 5; i++) {
			switch (parkForecast.get(i).getForecast()) { 
				case "snow": 	
					suggestions[i] = "Remember to pack your snowshoes!";
					break;
				
				case "rain":
					suggestions[i] = "Remember to pack your rain gear and wear waterproof shoes!";
					break;
				
				case "thunderstorms":
					suggestions[i] = "Seek shelters and avoid hiking on exposed ridges!";
					break;
				case "sunny":
					suggestions[i] = "Bring sunblock!";
					break;
			}
			
			if (parkForecast.get(i).getHigh() > 75) {
				temperatureSuggestions[i] = "Bring extra water!"; 
			}
			
			if((parkForecast.get(i).getHigh() - parkForecast.get(i).getLow()) > 20) {
				temperatureSuggestions[i] = "Wear breathable layers!"; 
			}
			
			if(parkForecast.get(i).getLow() < 20) {
				temperatureSuggestions[i] = "Danger! Long time exposures to low temperatures could be damaging!"; 
			}
			
		}
		
		
		request.setAttribute("park", parkDao.getParkByCode(parkCode));
		request.setAttribute("parkForecast", parkForecast);
		request.setAttribute("suggestions", suggestions);
		request.setAttribute("temperatureSuggestions", temperatureSuggestions);
		
		return "parkDetails";
	}
}
