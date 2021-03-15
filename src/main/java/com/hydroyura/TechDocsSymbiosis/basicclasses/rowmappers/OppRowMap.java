package com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;

public class OppRowMap implements RowMapper<OppEntity> {

	@Override
	public OppEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		OppEntity oppEntity = new OppEntity();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_ID)) oppEntity.setId(rs.getInt(Constants.TABLE_COLOMN_OPP_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_NAME)) oppEntity.setName(rs.getString(Constants.TABLE_COLOMN_OPP_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_NUMBER)) oppEntity.setNumber(rs.getString(Constants.TABLE_COLOMN_OPP_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_STATUS)) oppEntity.setStatus(rs.getString(Constants.TABLE_COLOMN_OPP_STATUS));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_VERSION)) oppEntity.setVersion(rs.getString(Constants.TABLE_COLOMN_OPP_VERSION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_UPDATE)) oppEntity.setUpdate(rs.getString(Constants.TABLE_COLOMN_OPP_UPDATE));
		
		return oppEntity;
	}

}
