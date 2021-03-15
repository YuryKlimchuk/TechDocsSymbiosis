package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.stp.StpEntity;

public class StpItemMap implements ItemMapper<StpEntity> {

	@Override
	public Map<String, String> getValues(StpEntity entity) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Constants.TABLE_COLOMN_STP_NAME, String.valueOf(entity.getName()));
		map.put(Constants.TABLE_COLOMN_STP_NUMBER, String.valueOf(entity.getNumber()));
		map.put(Constants.TABLE_COLOMN_STP_STANDART, String.valueOf(entity.getStandart()));
		return map;
	}



}
