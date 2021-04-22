package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;



@Component("ReversMapperFactory")
public class ReverseMapperFactory {
	

	private static OppReverseMapper oppRevMap;
	private static AsmReverseMapper asmRevMap;
	private static StpReverseMapper stpRevMap;
	private static SpecRowReverseMapper specRowRevMap;
	private static VzkReverseMapper vzkRevMap;
	private static BuyReverseMapper buyRevMap;
	private static OringReverseMapper oringRevMap;
	private static ProductReverseMapper productRevMap;
		
	@SuppressWarnings("unchecked")
	public static <T> ReverseMapper<T> generateRowMap(String FLAG) {
		ReverseMapper<T> revMapper;
		
		switch (FLAG) {

		case Constants.ROW_MAPPER_OPP:
			if(oppRevMap == null) 
				oppRevMap = new OppReverseMapper();
			revMapper = (ReverseMapper<T>) oppRevMap;
			break;
			
		case Constants.ROW_MAPPER_ASM:
			if(asmRevMap == null) 
				asmRevMap = new AsmReverseMapper();
			revMapper = (ReverseMapper<T>) asmRevMap;
			break;
			
		case Constants.ROW_MAPPER_SPEC:
			if(specRowRevMap == null) 
				specRowRevMap = new SpecRowReverseMapper();
			revMapper = (ReverseMapper<T>) specRowRevMap;
			break;
		
		case Constants.ROW_MAPPER_STP:
			if(stpRevMap == null) 
				stpRevMap = new StpReverseMapper();
			revMapper = (ReverseMapper<T>) stpRevMap;
			break;
		
		case Constants.ROW_MAPPER_VZK:
			if(vzkRevMap == null) 
				vzkRevMap = new VzkReverseMapper();
			revMapper = (ReverseMapper<T>) vzkRevMap;
			break;
			
		case Constants.ROW_MAPPER_BUY:
			if(buyRevMap == null) 
				buyRevMap = new BuyReverseMapper();
			revMapper = (ReverseMapper<T>) buyRevMap;
			break;
			
		case Constants.ROW_MAPPER_ORING:
			if(oringRevMap == null) 
				oringRevMap = new OringReverseMapper();
			revMapper = (ReverseMapper<T>) oringRevMap;
			break;
		
		
		case Constants.ROW_MAPPER_PRODUCT:
			if(productRevMap == null) 
				productRevMap = new ProductReverseMapper();
			revMapper = (ReverseMapper<T>) productRevMap;
			break;
		
			
		default:
			revMapper = null;
			break;
		}
		return revMapper;
	}

}
