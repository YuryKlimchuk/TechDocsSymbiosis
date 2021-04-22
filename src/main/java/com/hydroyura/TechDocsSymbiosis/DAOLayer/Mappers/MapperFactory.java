package com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;



@Component("MapperFactory")
public class MapperFactory {
	

	private static OppRowMap oppRowMap;
	private static AsmRowMap asmRowMap;
	private static SpecRowRowMap specRowRowMap;
	private static OringRowMap oringRowMap;
	private static BuyRowMap buyRowMap;
	private static VzkRowMap vzkRowMap;
	private static StpRowMap stpRowMap;
	private static ProductRowMap productRowMap;
		
	@SuppressWarnings("unchecked")
	public static <T> RowMapper<T> generateRowMap(String FLAG) {
		RowMapper<T> mapper;
		
		switch (FLAG) {

		case Constants.ROW_MAPPER_OPP:
			if(oppRowMap == null) 
				oppRowMap = new OppRowMap();
			mapper = (RowMapper<T>) oppRowMap;
			break;
			
		case Constants.ROW_MAPPER_ASM:
			if(asmRowMap == null) 
				asmRowMap = new AsmRowMap();
			mapper = (RowMapper<T>) asmRowMap;
			break;
			
		case Constants.ROW_MAPPER_SPEC:
			if(specRowRowMap == null) 
				specRowRowMap = new SpecRowRowMap();
			mapper = (RowMapper<T>) specRowRowMap;
			break;
		
		case Constants.ROW_MAPPER_ORING:
			if(oringRowMap == null) 
				oringRowMap = new OringRowMap();
			mapper = (RowMapper<T>) oringRowMap;
			break;
		
			
		case Constants.ROW_MAPPER_BUY:
			if(buyRowMap == null) 
				buyRowMap = new BuyRowMap();
			mapper = (RowMapper<T>) buyRowMap;
			break;
		
		case Constants.ROW_MAPPER_VZK:
			if(vzkRowMap == null) 
				vzkRowMap = new VzkRowMap();
			mapper = (RowMapper<T>) vzkRowMap;
			break;
		
		case Constants.ROW_MAPPER_STP:
			if(stpRowMap == null) 
				stpRowMap = new StpRowMap();
			mapper = (RowMapper<T>) stpRowMap;
			break;
		
		case Constants.ROW_MAPPER_PRODUCT:
			if(productRowMap == null) 
				productRowMap = new ProductRowMap();
			mapper = (RowMapper<T>) productRowMap;
			break;
			
		default:
			mapper = null;
			break;
		}
		return mapper;
	}

}
