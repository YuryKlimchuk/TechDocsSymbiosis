package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.data.DataAsm;

public class DataAsmItemMap implements ItemMapper<DataAsm> {


	@Override
	public Map<String, String> getValues(DataAsm entity) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, String.valueOf(entity.getId()));
		map.put(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_CHANGE, String.valueOf(entity.getChange()));
		map.put(Constants.TABLE_COLOMN_COMPOSITION_ENTITY_COUNTS, String.valueOf(entity.getCount()));
		map.put(Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, String.valueOf(entity.getAsmId()));
		return map;
	}



}
