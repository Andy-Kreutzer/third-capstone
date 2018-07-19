package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeather(String parkCode) {
		List<Weather> fiveDayForecast = new ArrayList<>();
		String sqlFiveDayWeather = "SELECT low, high, forecast FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFiveDayWeather, parkCode);
		while(results.next()) {
			fiveDayForecast.add(mapRowToWeather(results));
		}
		return fiveDayForecast;
	}
	
	

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather newWeather = new Weather();

		newWeather.setForecast(results.getString("forecast"));
		newWeather.setHigh(results.getInt("high"));
		newWeather.setLow(results.getInt("low"));
		newWeather.setForecastSuggestion(newWeather.getForecast());
		newWeather.setTempSuggestion(newWeather.getHigh(), newWeather.getLow());
		return newWeather;
	}


}
