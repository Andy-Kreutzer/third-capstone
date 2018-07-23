package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.npgeek.model.CodeCount;
import com.techelevator.npgeek.model.park.JDBCParkDAO;
import com.techelevator.npgeek.model.survey.JDBCSurveyDAO;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDAO;

public class SurveyDAOIntegrationTest extends DAOIntegrationTest {

	private SurveyDAO dao;
	
	@Before 
	public void setupTest() {
		dao = new JDBCSurveyDAO(super.getDataSource());
	}
	
	@Test
	public void testGetFavoritesFromSurveys() {
	    List<CodeCount> newCodeCounts = dao.getFavoritesFromSurveys();
	    
	    Assert.assertEquals("CVNP", newCodeCounts.get(0).getCode()); 
	    
	}
	
	@Test
	public void testSave() {
	    List<CodeCount> newCodeCounts = dao.getFavoritesFromSurveys();
	    int oldSize = newCodeCounts.size();
	    Survey newSurvey = new Survey();
	    
	    newSurvey.setActivityLevel("Hard");
	    newSurvey.setEmail("j@ok.com");
	    newSurvey.setParkCode("Not There");
	    newSurvey.setState("Ohio");
	    
	    dao.save(newSurvey);
	    
	    Assert.assertEquals(oldSize + 1, dao.getFavoritesFromSurveys().size());
	}
}
