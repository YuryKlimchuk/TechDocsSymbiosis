package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Opp;


public class OringReverseMapper implements ReverseMapper<Opp> {

	@Override
	public Map<String, Object> getEntityParameters(Opp entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put(Constants.TABLE_COLOMN_OPP_ID, entity.getId());
		map.put(Constants.TABLE_COLOMN_OPP_NAME, entity.getName());
		map.put(Constants.TABLE_COLOMN_OPP_NUMBER, entity.getNumber());
		map.put(Constants.TABLE_COLOMN_OPP_STATUS, entity.getStatus());
		map.put(Constants.TABLE_COLOMN_OPP_VERSION, entity.getVersion());
		map.put(Constants.TABLE_COLOMN_OPP_UPDATE, entity.getUpdate());
		
		return map;
	}

}
