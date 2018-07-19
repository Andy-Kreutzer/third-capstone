package com.techelevator.npgeek.model.weather;

import java.util.List;

public interface WeatherDAO {

	public List<Weather> getWeather(String parkCode);

	
}