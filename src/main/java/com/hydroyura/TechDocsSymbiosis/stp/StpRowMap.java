package com.hydroyura.TechDocsSymbiosis.stp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.init.Constants;

public class StpRowMap implements RowMapper<Stp> {

	@Override
	public Stp mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Stp stp = new Stp();
		
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_STP_ID)) stp.setId(rs.getInt(Constants.TABLE_COLOMN_STP_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_STP_NUMBER)) stp.setNumber(rs.getString(Constants.TABLE_COLOMN_STP_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_STP_NAME)) stp.setName(rs.getString(Constants.TABLE_COLOMN_STP_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_STP_STANDART)) stp.setStandart(rs.getString(Constants.TABLE_COLOMN_STP_STANDART));
		
		return stp;
	}

}
