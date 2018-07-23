package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.npgeek.model.weather.JDBCWeatherDAO;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDAO;

public class WeatherDAOIntegrationTest extends DAOIntegrationTest {

	private WeatherDAO dao;
	
	@Before 
	public void setupTest() {
		dao = new JDBCWeatherDAO(super.getDataSource());
	}
	
	@Test
	public void testGetParkByCode() {
	    List<Weather> newWeather = dao.getWeather("CVNP");
	    Assert.assertEquals("rain", newWeather.get(0).getForecast());
		}
	}

