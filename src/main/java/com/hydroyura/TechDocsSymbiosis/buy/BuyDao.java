package com.hydroyura.TechDocsSymbiosis.buy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.hydroyura.TechDocsSymbiosis.init.Constants;


@Component
public class BuyDao {
	
	@Autowired
	private JdbcTemplate jdbc;

	
	public List<Buy> getAll() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_BUY + ";";
		return jdbc.query(query, new BuyRowMap());
	}
	
}
