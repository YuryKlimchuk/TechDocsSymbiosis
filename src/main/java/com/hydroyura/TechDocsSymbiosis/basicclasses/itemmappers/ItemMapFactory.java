package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;

public class ItemMapFactory {
	private static ItemMapper<OppEntity> oppItemMap;
	
	public static ItemMapper<?> generateItemMap(String FLAG) {
		ItemMapper<?> mapper;
		
		switch (FLAG) {
			
		case Constants.ROW_MAPPER_OPP:
			if(oppItemMap == null) 
				oppItemMap = new OppItemMap();
			mapper = oppItemMap;
			break;
			
			
		default:
			mapper = null;
			break;
		}
		return mapper;
	}
}
