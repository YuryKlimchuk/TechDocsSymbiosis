package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Stp;


public class StpReverseMapper implements ReverseMapper<Stp> {

	@Override
	public Map<String, Object> getEntityParameters(Stp entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put(Constants.TABLE_COLOMN_STP_NAME, entity.getName());
		map.put(Constants.TABLE_COLOMN_STP_NUMBER, entity.getNumber());
		map.put(Constants.TABLE_COLOMN_STP_STANDART, entity.getStandart());
		
		return map;
	}

}
