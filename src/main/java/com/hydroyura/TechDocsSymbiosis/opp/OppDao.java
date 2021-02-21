package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component
public class OppDao {
	
	
	private JdbcTemplate jdbc;
	
	
	@Autowired
	public OppDao(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public List<Opp> getOppList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_OPP + ";";
		return jdbc.query(query, new OppRowMap());
	} 
	
	public List<Opp> getOppListByStatus(String status) {
		return null;
	}
	
	public Opp getOppbyId(int id) {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_OPP + " WHERE " + Constants.TABLE_COLOMN_OPP_ID + "='" + id +"';";
		return jdbc.queryForObject(query, new OppRowMap());
	}

}
