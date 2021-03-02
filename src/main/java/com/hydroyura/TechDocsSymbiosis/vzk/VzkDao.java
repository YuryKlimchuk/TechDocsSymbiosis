package com.hydroyura.TechDocsSymbiosis.vzk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component
public class VzkDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Vzk> getVzkList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_VZK;
		return jdbc.query(query, new VzkRowMap());
	}
	
	
	

}
