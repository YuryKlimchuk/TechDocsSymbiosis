package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;


public class AsmRowMap implements RowMapper<Asm> {

	@Override
	public Asm mapRow(ResultSet rs, int rowNum) throws SQLException {
		Asm entity = new Asm();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_ID)) entity.setId(rs.getLong(Constants.TABLE_COLOMN_ASM_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_NAME)) entity.setName(rs.getString(Constants.TABLE_COLOMN_ASM_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_NUMBER)) entity.setNumber(rs.getString(Constants.TABLE_COLOMN_ASM_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_STATUS)) entity.setStatus(rs.getString(Constants.TABLE_COLOMN_ASM_STATUS));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_VERSION)) entity.setVersion(rs.getString(Constants.TABLE_COLOMN_ASM_VERSION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_UPDATE)) entity.setUpdate(rs.getString(Constants.TABLE_COLOMN_ASM_UPDATE));
		
		return entity;
	}

}
