package com.hydroyura.TechDocsSymbiosis.vzk;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.init.Constants;

public class VzkRowMap implements RowMapper<VzkEntity> {

	@Override
	public VzkEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		VzkEntity stp = new VzkEntity();
		
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_ID)) stp.setId(rs.getInt(Constants.TABLE_COLOMN_VZK_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_NUMBER)) stp.setNumber(rs.getString(Constants.TABLE_COLOMN_VZK_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_NAME)) stp.setName(rs.getString(Constants.TABLE_COLOMN_VZK_NAME));
		
		return stp;
	}

}
