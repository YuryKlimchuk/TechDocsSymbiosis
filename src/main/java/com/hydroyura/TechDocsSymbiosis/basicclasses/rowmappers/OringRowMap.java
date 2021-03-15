package com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.oring.OringEntity;


public class OringRowMap implements RowMapper<OringEntity> {

	@Override
	public OringEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		OringEntity oring = new OringEntity();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_ID)) oring.setId(rs.getInt(Constants.TABLE_COLOMN_ORINGS_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_NUMBER)) oring.setNumber(rs.getString(Constants.TABLE_COLOMN_ORINGS_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_NAME)) oring.setName(rs.getString(Constants.TABLE_COLOMN_ORINGS_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION)) oring.setCrossSection(rs.getFloat(Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER)) oring.setInnerDiameter(rs.getFloat(Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_STANDART)) oring.setStandart(rs.getString(Constants.TABLE_COLOMN_ORINGS_STANDART));
		
		return oring;
	}

}
