package com.techelevator.npgeek.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	@Override
	public Park getParkByCode(String parkCode) {
		Park newPark = null;
		String sqlGetParkByCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkByCode, parkCode);
		while(results.next()) {
			newPark = mapRowToPark(results);
		}
		
		return newPark;
	}
	
	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkCode(row.getString("parkcode"));
		park.setParkName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevation(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getFloat("milesoftrail"));
		park.setNumOfCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitors(row.getInt("annualvisitorcount"));
		park.setQuote(row.getString("inspirationalquote"));
		park.setQuoteSource(row.getString("inspirationalquotesource"));
		park.setParkDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getInt("entryFee"));
		park.setNumOfAnimalSpec(row.getInt("numberofanimalspecies"));
		
		return park;
	}
}
