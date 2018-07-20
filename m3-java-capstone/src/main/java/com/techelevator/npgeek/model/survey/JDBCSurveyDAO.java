package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.CodeCount;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CodeCount> getFavoritesFromSurveys() {
		List<CodeCount> codeCounts = new ArrayList<>();
		String sqlCodeCount = "SELECT parkcode, COUNT(*) FROM survey_result " +
									 "GROUP BY parkcode " +
									 "HAVING COUNT(*) > 0 " +
									 "ORDER BY COUNT(*) DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCodeCount);
		while(results.next()) {
			CodeCount newCodeCount = new CodeCount();
			newCodeCount.setCode(results.getString("parkcode"));
			newCodeCount.setCount(results.getInt("count"));
			codeCounts.add(newCodeCount);
		}
		return codeCounts;
	}

	@Override
	public void save(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());	
	}
	
}
