package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component
public class OringDao {
	
	private JdbcTemplate jdbc;

	@Autowired
	public OringDao(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	
	// return full list of o-rings
	public List<Oring> getOringList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS + ";";
		return jdbc.query(query, new OringRowMap());
	}
	
	
	// return List of kind cross section
	public List<Float> getOringCrossSections() {
		
		String query = "SELECT DISTINCT " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + " FROM " + Constants.TABLE_NAME_ORINGS 
				+ " ORDER BY " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + ";";
		
		List<Float> crossSectionList = jdbc.queryForList(query, Float.class);
		
		return crossSectionList;
	}
	
	
	public List<Oring> getOringListByCrossSectionAndInnerDiameter(List<Float> crossSectionDiameters, float minInnerDiameter, float maxInnerDiameter) {
		
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS 
				+ " WHERE " + Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER 
				+ " BETWEEN '" + minInnerDiameter + "' AND '" + maxInnerDiameter + "'";
		
		if((crossSectionDiameters == null) || (crossSectionDiameters.size() == 0)) {
			query = query + ";";
		} else {
			
			query = query + "AND " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + " IN (";
			
			for (Float diameter : crossSectionDiameters) {
				query = query + "'" + diameter + "',";
			}
			
			query = query.substring(0, query.length()-1);
			query = query + ");";
		}
		
		return jdbc.query(query, new OringRowMap());
	}
	
	public Float getOringsMinInternalDiameter() {
		String query = "SELECT MIN(" + Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + ") FROM " + Constants.TABLE_NAME_ORINGS + ";";
		return jdbc.queryForObject(query, Float.class);
	}
	
	public Float getOringsMaxInternalDiameter() {
		String query = "SELECT MAX(" + Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + ") FROM " + Constants.TABLE_NAME_ORINGS + ";";
		return jdbc.queryForObject(query, Float.class);
	}
	

}
