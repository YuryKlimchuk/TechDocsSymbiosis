package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.SpecificationRow;


public class SpecRowReverseMapper implements ReverseMapper<SpecificationRow> {

	@Override
	public Map<String, Object> getEntityParameters(SpecificationRow entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put(Constants.TABLE_COLOMN_SPECROW_ID, entity.getElementId());
		map.put(Constants.TABLE_COLOMN_SPECROW_ASM_FULL_ID, entity.getAsmId());
		map.put(Constants.TABLE_COLOMN_SPECROW_COUNTS, entity.getCount());
		map.put(Constants.TABLE_COLOMN_SPECROW_CHANGE, entity.getChange());
		map.put(Constants.TABLE_COLOMN_SPECROW_TYPE, entity.getRowType());
		
		return map;
	}

}
