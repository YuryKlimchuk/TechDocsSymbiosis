package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Opp;


public class OppRowMap implements RowMapper<Opp> {

	@Override
	public Opp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Opp entity = new Opp();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_ID)) entity.setId(rs.getLong(Constants.TABLE_COLOMN_OPP_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_NAME)) entity.setName(rs.getString(Constants.TABLE_COLOMN_OPP_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_NUMBER)) entity.setNumber(rs.getString(Constants.TABLE_COLOMN_OPP_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_STATUS)) entity.setStatus(rs.getString(Constants.TABLE_COLOMN_OPP_STATUS));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_VERSION)) entity.setVersion(rs.getString(Constants.TABLE_COLOMN_OPP_VERSION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_UPDATE)) entity.setUpdate(rs.getString(Constants.TABLE_COLOMN_OPP_UPDATE));
		
		return entity;
	}

}
