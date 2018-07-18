package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.CodeCount;
import com.techelevator.npgeek.model.park.Park;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CodeCount> getFavoritesFromSurveys() {
		List<CodeCount> allSurveys = new ArrayList<>();
		String sqlCountFavoriteParks = "SELECT parkcode, COUNT(*) FROM survey_result " +
									 "GROUP BY parkcode " +
									 "HAVING COUNT(*) > 0 " +
									 "ORDER BY COUNT(*) DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCountFavoriteParks);
		while(results.next()) {
			CodeCount cc = new CodeCount();
			allSurveys.add(cc);
		}
		return allSurveys;
	}

	@Override
	public void save(Survey survey) {
		Long id = getNextId();
		String sqlInsertSurvey = "INSERT INTO survey_result(id, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, id, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
		survey.setId(id);	
	}
	
	private Survey mapRowToSurvey(SqlRowSet row) {
		Survey survey = new Survey();
		survey.setId(row.getLong("surveyid"));
		survey.setParkCode(row.getString("parkcode"));
		survey.setEmail(row.getString("emailaddress"));
		survey.setState(row.getString("state"));
		survey.setActivityLevel(row.getString("activitylevel"));
		return survey;
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_survey_result_id')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}
}
