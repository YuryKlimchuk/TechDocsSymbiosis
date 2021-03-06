package com.hydroyura.TechDocsSymbiosis.asm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

public class AsmRowMap implements RowMapper<AsmEntity> {

	@Override
	public AsmEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		AsmEntity asm = new AsmEntity();
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_ID)) asm.setId(rs.getInt(Constants.TABLE_COLOMN_ASM_ID));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_NAME)) asm.setName(rs.getString(Constants.TABLE_COLOMN_ASM_NAME));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_NUMBER)) asm.setNumber(rs.getString(Constants.TABLE_COLOMN_ASM_NUMBER));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_STATUS)) asm.setStatus(rs.getString(Constants.TABLE_COLOMN_ASM_STATUS));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_VERSION)) asm.setVersion(rs.getString(Constants.TABLE_COLOMN_ASM_VERSION));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_ASM_UPDATE)) asm.setUpdate(rs.getString(Constants.TABLE_COLOMN_ASM_UPDATE));
		return asm;
	}

}