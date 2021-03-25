package com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.data.DataAsm;

public class DataAsmRowMap implements RowMapper<DataAsm> {

	@Override
	public DataAsm mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DataAsm stp = new DataAsm();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID)) stp.setAsmId(rs.getInt(Constants.TABLE_COLOMN_COMPOSITION_ASM_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID)) stp.setId(rs.getInt(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_COUNTS)) stp.setCount(rs.getInt(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_COUNTS));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_CHANGE)) stp.setChange(rs.getInt(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_CHANGE));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_OPP_NUMBER)) stp.setNumber(rs.getString(Constants.TABLE_COLOMN_OPP_NUMBER));
		
		return stp;
	}

}
