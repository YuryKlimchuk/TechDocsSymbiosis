package com.hydroyura.TechDocsSymbiosis.asm.partofasm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.init.Constants;

public class PartOfAsmRowMap implements RowMapper<PartOfAsmEntity> {

	@Override
	public PartOfAsmEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PartOfAsmEntity partOfAsm = new PartOfAsmEntity();
		
		
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID)) partOfAsm.setAsmId((rs.getInt(Constants.TABLE_COLOMN_COMPOSITION_ASM_ID)));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID)) partOfAsm.setId((rs.getInt(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID)));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_COUNTS)) partOfAsm.setCount((rs.getInt(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_COUNTS)));
		if(Constants.isThere(rs, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_CHANGE)) partOfAsm.setChange((rs.getInt(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_CHANGE)));

		
		return partOfAsm;
	}

}
