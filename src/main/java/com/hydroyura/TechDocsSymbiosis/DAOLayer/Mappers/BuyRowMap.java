package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Buy;


public class BuyRowMap implements RowMapper<Buy> {

	@Override
	public Buy mapRow(ResultSet rs, int rowNum) throws SQLException {
		Buy entity = new Buy();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_BUY_ID)) entity.setId(rs.getLong(Constants.TABLE_COLOMN_BUY_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_BUY_NAME)) entity.setName(rs.getString(Constants.TABLE_COLOMN_BUY_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_BUY_NUMBER)) entity.setNumber(rs.getString(Constants.TABLE_COLOMN_BUY_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_BUY_MANUFACTURER)) entity.setManufacturer(rs.getString(Constants.TABLE_COLOMN_BUY_MANUFACTURER));
		return entity;
	}

}
