package com.techelevator.npgeek.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.npgeek.model.survey.SurveyDAO;


@Controller
public class FavoriteController {
	
	@Autowired
	private SurveyDAO surveyDao;
	
	@RequestMapping(path="/favoriteParks", method=RequestMethod.GET)
	public String showFavorite(HttpServletRequest request) {
		request.setAttribute("favorites", surveyDao.getFavoritesFromSurveys());
		return "favoriteParks";
	}
	
	
}