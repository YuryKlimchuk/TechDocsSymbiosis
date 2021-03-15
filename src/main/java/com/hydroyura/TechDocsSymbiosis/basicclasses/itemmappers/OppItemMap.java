package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;

public class OppItemMap implements ItemMapper<OppEntity> {


	@Override
	public Map<String, String> getValues(OppEntity entity) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Constants.TABLE_COLOMN_OPP_NAME, String.valueOf(entity.getName()));
		map.put(Constants.TABLE_COLOMN_OPP_NUMBER, String.valueOf(entity.getNumber()));
		map.put(Constants.TABLE_COLOMN_OPP_STATUS, String.valueOf(entity.getStatus()));
		map.put(Constants.TABLE_COLOMN_OPP_VERSION, String.valueOf(entity.getVersion()));
		map.put(Constants.TABLE_COLOMN_OPP_UPDATE, String.valueOf(entity.getUpdate()));
		return map;
	}



}
