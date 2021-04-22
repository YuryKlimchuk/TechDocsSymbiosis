package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Oring;


public class OringRowMap implements RowMapper<Oring> {

	@Override
	public Oring mapRow(ResultSet rs, int rowNum) throws SQLException {
		Oring entity = new Oring();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_ID)) entity.setId(rs.getLong(Constants.TABLE_COLOMN_ORINGS_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_NAME)) entity.setName(rs.getString(Constants.TABLE_COLOMN_ORINGS_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_NUMBER)) entity.setNumber(rs.getString(Constants.TABLE_COLOMN_ORINGS_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION)) entity.setCrossSection(rs.getFloat(Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER)) entity.setInnerDiameter(rs.getFloat(Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ORINGS_STANDART)) entity.setStandart(rs.getString(Constants.TABLE_COLOMN_ORINGS_STANDART));

		return entity;
	}

}
