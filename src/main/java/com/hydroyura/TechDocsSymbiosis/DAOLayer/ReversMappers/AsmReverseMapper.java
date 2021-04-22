package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;


public class AsmReverseMapper implements ReverseMapper<Asm> {

	@Override
	public Map<String, Object> getEntityParameters(Asm entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put(Constants.TABLE_COLOMN_ASM_NAME, entity.getName());
		map.put(Constants.TABLE_COLOMN_ASM_NUMBER, entity.getNumber());
		map.put(Constants.TABLE_COLOMN_ASM_STATUS, entity.getStatus());
		map.put(Constants.TABLE_COLOMN_ASM_VERSION, entity.getVersion());
		map.put(Constants.TABLE_COLOMN_ASM_UPDATE, entity.getUpdate());
		
		return map;
	}

}
