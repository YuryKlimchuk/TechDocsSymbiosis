package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;


public class VzkReverseMapper implements ReverseMapper<Vzk> {

	@Override
	public Map<String, Object> getEntityParameters(Vzk entity) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put(Constants.TABLE_COLOMN_VZK_NAME, entity.getName());
		map.put(Constants.TABLE_COLOMN_VZK_NUMBER, entity.getNumber());
		
		return map;
	}

}
