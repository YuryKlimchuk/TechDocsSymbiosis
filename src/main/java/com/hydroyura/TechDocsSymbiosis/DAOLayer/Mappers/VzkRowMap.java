package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;


public class VzkRowMap implements RowMapper<Vzk> {

	@Override
	public Vzk mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vzk entity = new Vzk();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_ID)) entity.setId(rs.getLong(Constants.TABLE_COLOMN_VZK_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_NAME)) entity.setName(rs.getString(Constants.TABLE_COLOMN_VZK_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_NUMBER)) entity.setNumber(rs.getString(Constants.TABLE_COLOMN_VZK_NUMBER));
		
		return entity;
	}

}
