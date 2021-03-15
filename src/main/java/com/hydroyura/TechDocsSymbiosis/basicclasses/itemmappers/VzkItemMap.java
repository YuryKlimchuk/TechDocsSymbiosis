package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.vzk.VzkEntity;

public class VzkItemMap implements ItemMapper<VzkEntity> {

	@Override
	public Map<String, String> getValues(VzkEntity entity) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Constants.TABLE_COLOMN_VZK_NAME, String.valueOf(entity.getName()));
		map.put(Constants.TABLE_COLOMN_VZK_NUMBER, String.valueOf(entity.getNumber()));
		return map;
	}
}
