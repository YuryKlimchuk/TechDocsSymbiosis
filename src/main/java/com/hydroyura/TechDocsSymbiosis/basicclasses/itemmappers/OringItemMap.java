package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.oring.OringEntity;

public class OringItemMap implements ItemMapper<OringEntity> {


	@Override
	public Map<String, String> getValues(OringEntity entity) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Constants.TABLE_COLOMN_ORINGS_NAME, String.valueOf(entity.getName()));
		map.put(Constants.TABLE_COLOMN_ORINGS_NUMBER, String.valueOf(entity.getNumber()));
		map.put(Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER, String.valueOf(entity.getInnerDiameter()));
		map.put(Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION, String.valueOf(entity.getCrossSection()));
		map.put(Constants.TABLE_COLOMN_ORINGS_STANDART, String.valueOf(entity.getStandart()));
		return map;
	}



}
