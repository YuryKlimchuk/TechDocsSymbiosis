package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Buy;


public class BuyReverseMapper implements ReverseMapper<Buy> {

	@Override
	public Map<String, Object> getEntityParameters(Buy entity) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put(Constants.TABLE_COLOMN_BUY_NAME, entity.getName());
		map.put(Constants.TABLE_COLOMN_BUY_NUMBER, entity.getNumber());
		map.put(Constants.TABLE_COLOMN_BUY_MANUFACTURER, entity.getManufacturer());
		
		return map;
	}

}
