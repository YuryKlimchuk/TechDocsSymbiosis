package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.asm.AsmEntity;
import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;

public class AsmItemMap implements ItemMapper<AsmEntity> {


	@Override
	public Map<String, String> getValues(AsmEntity entity) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Constants.TABLE_COLOMN_ASM_NAME, String.valueOf(entity.getName()));
		map.put(Constants.TABLE_COLOMN_ASM_NUMBER, String.valueOf(entity.getNumber()));
		map.put(Constants.TABLE_COLOMN_ASM_STATUS, String.valueOf(entity.getStatus()));
		map.put(Constants.TABLE_COLOMN_ASM_VERSION, String.valueOf(entity.getVersion()));
		map.put(Constants.TABLE_COLOMN_ASM_UPDATE, String.valueOf(entity.getUpdate()));
		return map;
	}



}
