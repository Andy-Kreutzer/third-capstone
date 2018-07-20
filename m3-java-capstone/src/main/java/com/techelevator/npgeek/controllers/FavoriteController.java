package com.techelevator.npgeek.controllers;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.CodeCount;
import com.techelevator.npgeek.model.park.ParkDAO;
import com.techelevator.npgeek.model.survey.SurveyDAO;


@Controller
public class FavoriteController {
	
	@Autowired
	private SurveyDAO surveyDao;
	
	@Autowired
	private ParkDAO parkDao;
	
	@RequestMapping(path="/favoriteParks", method=RequestMethod.GET)
	public String showFavorite(HttpServletRequest request) {
		ArrayList<CodeCount> favoriteCodeCounts = (ArrayList<CodeCount>) surveyDao.getFavoritesFromSurveys();
		ArrayList <String> parkNames = new ArrayList<String>();
		for (CodeCount e : favoriteCodeCounts) {
        	 if ((e.getCode().equals("CVNP"))) {
        		 parkNames.add("Cuyahoga Valley National Park");
        	 }
        	 else if ((e.getCode().equals("ENP"))) {
        		 parkNames.add("Everglades National Park");
        	 }
        	 else if ((e.getCode().equals("GCNP"))) {
        		 parkNames.add("Grand Canyon National Park");
        	 }
        	 else if ((e.getCode().equals("GNP"))) {
        		 parkNames.add("Glacier National Park");
        	 }
        	 else if ((e.getCode().equals("GSMNP"))) {
        		 parkNames.add("Great Smoky Mountains National Park");
        	 }
        	 else if ((e.getCode().equals("GTNP"))) {
        		 parkNames.add("Grand Teton National Park");
        	 }
        	 else if ((e.getCode().equals("MRNP"))) {
        		 parkNames.add("Mount Rainier National Park");
        	 }
        	 else if ((e.getCode().equals("RMNP"))) {
        		 parkNames.add("Rocky Mountain National Park");
        	 }
        	 else if ((e.getCode().equals("YNP"))) {
        		 parkNames.add("Yellowstone National Park");
        	 }
        	 else if ((e.getCode().equals("YNP2"))) {
        		 parkNames.add("Yosemite National Park");
        	 }     	 
		}
		
		request.setAttribute("favorites", favoriteCodeCounts);
		request.setAttribute("names", parkNames); 
		return "favoriteParks";
	}
	
	
}