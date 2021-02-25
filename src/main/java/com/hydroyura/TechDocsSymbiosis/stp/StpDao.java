package com.hydroyura.TechDocsSymbiosis.stp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component
public class StpDao {
	
	
	private JdbcTemplate jdbc; 

	@Autowired
	public StpDao(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	
	public List<Stp> getStpList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ST + ";";
		return jdbc.query(query, new StpRowMap());
	}
	
	
	
}
