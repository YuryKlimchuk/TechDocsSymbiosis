package com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.asm.AsmEntity;
import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;

public class AsmRowMap implements RowMapper<AsmEntity> {

	@Override
	public AsmEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		AsmEntity oppEntity = new AsmEntity();
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_ID)) oppEntity.setId(rs.getInt(Constants.TABLE_COLOMN_ASM_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_NAME)) oppEntity.setName(rs.getString(Constants.TABLE_COLOMN_ASM_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_NUMBER)) oppEntity.setNumber(rs.getString(Constants.TABLE_COLOMN_ASM_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_STATUS)) oppEntity.setStatus(rs.getString(Constants.TABLE_COLOMN_ASM_STATUS));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_VERSION)) oppEntity.setVersion(rs.getString(Constants.TABLE_COLOMN_ASM_VERSION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_UPDATE)) oppEntity.setUpdate(rs.getString(Constants.TABLE_COLOMN_ASM_UPDATE));
		
		return oppEntity;
	}

}
