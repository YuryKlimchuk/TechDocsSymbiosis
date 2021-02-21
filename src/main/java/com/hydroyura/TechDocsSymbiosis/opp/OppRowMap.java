package com.hydroyura.TechDocsSymbiosis.opp;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

public class OppRowMap implements RowMapper<Opp> {

	@Override
	public Opp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Opp opp = new Opp();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_ID)) opp.setId(rs.getInt(Constants.TABLE_COLOMN_OPP_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_NAME)) opp.setName(rs.getString(Constants.TABLE_COLOMN_OPP_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_NUMBER)) opp.setNumber(rs.getString(Constants.TABLE_COLOMN_OPP_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_STATUS)) opp.setStatus(rs.getString(Constants.TABLE_COLOMN_OPP_STATUS));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_VERSION)) opp.setVersion(rs.getString(Constants.TABLE_COLOMN_OPP_VERSION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_UPDATE)) opp.setUpdate(rs.getString(Constants.TABLE_COLOMN_OPP_UPDATE));
		//if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_COMP_OPP_COUNTS)) opp.setCountsInAsm(rs.getInt(Constants.TABLE_COLOMN_ASM_COMP_OPP_COUNTS));
		
		return opp;
	}

}
