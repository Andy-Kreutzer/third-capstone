package com.techelevator.npgeek.model.survey;

import java.util.List;

public interface SurveyDAO {
	public List<Survey> getFavoritesFromSurveys();
	public void save(Survey survey);
}
