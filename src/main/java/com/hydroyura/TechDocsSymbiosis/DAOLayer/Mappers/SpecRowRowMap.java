package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.SpecificationRow;


public class SpecRowRowMap implements RowMapper<SpecificationRow> {

	@Override
	public SpecificationRow mapRow(ResultSet rs, int rowNum) throws SQLException {
		SpecificationRow entity = new SpecificationRow();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_SPECROW_ASM_FULL_ID )) entity.setAsmId(rs.getLong(Constants.TABLE_COLOMN_SPECROW_ASM_FULL_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_SPECROW_ID )) entity.setElementId(rs.getLong(Constants.TABLE_COLOMN_SPECROW_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_SPECROW_COUNTS )) entity.setCount(rs.getLong(Constants.TABLE_COLOMN_SPECROW_COUNTS));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_SPECROW_CHANGE )) entity.setChange(rs.getLong(Constants.TABLE_COLOMN_SPECROW_CHANGE));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_SPECROW_TYPE )) entity.setRowType(rs.getString(Constants.TABLE_COLOMN_SPECROW_TYPE));
		
		return entity;
	}

}
