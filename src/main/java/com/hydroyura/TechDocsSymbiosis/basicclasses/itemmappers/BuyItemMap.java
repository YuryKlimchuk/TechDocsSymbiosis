package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.buy.BuyEntity;

public class BuyItemMap implements ItemMapper<BuyEntity> {

	@Override
	public Map<String, String> getValues(BuyEntity entity) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Constants.TABLE_COLOMN_BUY_NAME, String.valueOf(entity.getName()));
		map.put(Constants.TABLE_COLOMN_BUY_NUMBER, String.valueOf(entity.getNumber()));
		map.put(Constants.TABLE_COLOMN_BUY_MANUFACTURER, String.valueOf(entity.getManufacturer()));
		return map;
	}
}
