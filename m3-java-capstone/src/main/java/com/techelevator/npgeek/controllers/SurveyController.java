package com.techelevator.npgeek.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDAO;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyDAO surveyDao;
	
	// GET: /register
	// Return the empty registration view
	@RequestMapping(path="/surveyPage", method=RequestMethod.GET)
	public String showSurvey(Model modelHolder) {
		
		if(!modelHolder.containsAttribute("survey")) {
			modelHolder.addAttribute("survey", new Survey());
		}
		return "surveyPage";
	}
	
	// POST: /register
	// Validate the model and redirect to confirmation (if successful) or return
	// the
	// registration view (if validation fails)

	@RequestMapping(path="/surveyPage", method=RequestMethod.POST)
	public String handleSurveyForm(@Valid @ModelAttribute("survey") Survey survey, BindingResult result, 
				RedirectAttributes attr, HttpServletRequest request) {
	    
	    attr.addFlashAttribute("survey", survey);
	    if(result.hasErrors()) {
	        attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
	        return "redirect:/surveyPage";
	    }
	    
	    surveyDao.save(survey);
	    
	    return "redirect:/favoriteParks";
	}
	
}