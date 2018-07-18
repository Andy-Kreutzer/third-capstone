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
import com.techelevator.npgeek.model.survey.SurveyDAO;


@Controller
public class FavoriteController {
	
	@Autowired
	private ParkDAO parkDao;
	
	@Autowired
	private SurveyDAO surveyDao;
	
	@RequestMapping(path="/favoriteParks", method=RequestMethod.GET)
	public String showFavorite(HttpServletRequest request) {
		request.setAttribute("favorites", surveyDao.getFavoriteParks());
		return "favoriteParks";
	}
}