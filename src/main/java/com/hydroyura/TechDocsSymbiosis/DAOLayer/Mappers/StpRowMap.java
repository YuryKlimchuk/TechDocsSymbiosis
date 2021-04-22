package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Stp;


public class StpRowMap implements RowMapper<Stp> {

	@Override
	public Stp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Stp entity = new Stp();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_STP_ID)) entity.setId(rs.getLong(Constants.TABLE_COLOMN_STP_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_STP_NAME)) entity.setName(rs.getString(Constants.TABLE_COLOMN_STP_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_STP_NUMBER)) entity.setNumber(rs.getString(Constants.TABLE_COLOMN_STP_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_STP_STANDART)) entity.setStandart(rs.getString(Constants.TABLE_COLOMN_STP_STANDART));

		return entity;
	}

}
