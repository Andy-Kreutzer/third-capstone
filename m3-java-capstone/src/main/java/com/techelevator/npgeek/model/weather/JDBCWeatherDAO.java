package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCWeatherDAO implements WeatherDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getAllWeather() {
		List<Weather> allWeathers = new ArrayList<>();
		String sqlAllWeathers = "SELECT * FROM weather";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllWeathers);
		while(results.next()) {
			allWeathers.add(mapRowToWeather(results));
		}
		return allWeathers;
	}

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather newWeather = new Weather();
		
		newWeather.setFiveDayForecastValue(results.getInt("fivedayforecast"));
		newWeather.setForecast(results.getString("forecast"));
		newWeather.setParkcode(results.getString("parkcode"));
		newWeather.setHigh(results.getInt("high"));
		newWeather.setLow(results.getInt("low"));
		return null;
	}
}
