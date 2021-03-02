package com.hydroyura.TechDocsSymbiosis.vzk;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

public class VzkRowMap implements RowMapper<Vzk> {

	@Override
	public Vzk mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vzk vzk = new Vzk();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_ID)) vzk.setId(rs.getInt(Constants.TABLE_COLOMN_VZK_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_NUMBER)) vzk.setNumber(rs.getString(Constants.TABLE_COLOMN_VZK_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_VZK_NAME)) vzk.setName(rs.getString(Constants.TABLE_COLOMN_VZK_NAME));
		
		return vzk;
	}

}
