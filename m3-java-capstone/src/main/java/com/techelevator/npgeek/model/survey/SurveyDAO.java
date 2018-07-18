package com.techelevator.npgeek.model.survey;

import java.util.List;

import com.techelevator.npgeek.model.CodeCount;

public interface SurveyDAO {
	public List<CodeCount> getFavoritesFromSurveys();
	public void save(Survey survey);
}
