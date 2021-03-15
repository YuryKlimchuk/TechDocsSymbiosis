package com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;

// Factory which generate RowMappers for each entity in database
@Component("RowMapFactory")
public class RowMapFactory {
	

	private static OppRowMap oppRowMap;
	private static OringRowMap oringRowMap;
	private static BuyRowMap buyRowMap;
	private static VzkRowMap vzkRowMap;
	private static StpRowMap stpRowMap;
		
	public static RowMapper<?> generateRowMap(String FLAG) {
		RowMapper<?> mapper;
		
		switch (FLAG) {

		case Constants.ROW_MAPPER_OPP:
			if(oppRowMap == null) 
				oppRowMap = new OppRowMap();
			mapper = oppRowMap;
			break;
			
		case Constants.ROW_MAPPER_ORING:
			if(oringRowMap == null) 
				oringRowMap = new OringRowMap();
			mapper = oringRowMap;
			break;
			
		case Constants.ROW_MAPPER_BUY:
			if(buyRowMap == null) 
				buyRowMap = new BuyRowMap();
			mapper = buyRowMap;
			break;
			
		case Constants.ROW_MAPPER_VZK:
			if(vzkRowMap == null) 
				vzkRowMap = new VzkRowMap();
			mapper = vzkRowMap;
			break;
			
		case Constants.ROW_MAPPER_STP:
			if(stpRowMap == null) 
				stpRowMap = new StpRowMap();
			mapper = stpRowMap;
			break;
			
		default:
			mapper = null;
			break;
		}
		return mapper;
	}

}
