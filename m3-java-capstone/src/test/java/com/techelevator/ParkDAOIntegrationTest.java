package com.techelevator;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.park.JDBCParkDAO;
import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDAO;

import org.junit.Before;


public class ParkDAOIntegrationTest extends DAOIntegrationTest {

	//@Autowired
	private ParkDAO dao;

//	private static SingleConnectionDataSource dataSource;
	
//	@BeforeClass
//	public static void setupDataSource() {
//		dataSource = new SingleConnectionDataSource();
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
//		dataSource.setUsername("postgres");
//		dataSource.setAutoCommit(false);
//	}
		
	@Before 
	public void setupTest() {
		dao = new JDBCParkDAO(super.getDataSource());
	}
	@Test
	public void testGetParkByCode() {
	    String parkCode = "CVNP";
	    Park testPark = dao.getParkByCode(parkCode);
	    
	    Assert.assertEquals("CVNP", testPark.getParkCode());
	}
	
	@Test
	public void testGetAllParks() {
	    List<Park> parks = dao.getAllParks();
	    
	    Assert.assertNotNull(parks);
	}
	
//	@AfterClass
//	public static void closeDataSource() throws SQLException {
//		dataSource.destroy();
//	}
//	
//	public DataSource getDataSource() {
//		return dataSource;
//	}
}
