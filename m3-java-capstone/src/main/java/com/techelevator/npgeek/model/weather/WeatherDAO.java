package com.techelevator.npgeek.model.weather;

import java.util.List;

import com.techelevator.npgeek.model.park.Park;

public interface WeatherDAO {

	public List<Weather> getWeather(Park selectedPark);
	
}