package com.hydroyura.TechDocsSymbiosis.buy;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.init.Constants;

public class BuyRowMap implements RowMapper<BuyEntity> {

	@Override
	public BuyEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BuyEntity buy = new BuyEntity();
		
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_BUY_ID)) buy.setId(rs.getInt(Constants.TABLE_COLOMN_BUY_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_BUY_NUMBER)) buy.setNumber(rs.getString(Constants.TABLE_COLOMN_BUY_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_BUY_NAME)) buy.setName(rs.getString(Constants.TABLE_COLOMN_BUY_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_BUY_MANUFACTURER)) buy.setManufacturer(rs.getString(Constants.TABLE_COLOMN_BUY_MANUFACTURER));
		
		return buy;
	}

}
