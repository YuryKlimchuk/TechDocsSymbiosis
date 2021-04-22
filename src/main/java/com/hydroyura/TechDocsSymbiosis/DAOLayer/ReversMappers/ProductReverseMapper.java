package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Product;


public class ProductReverseMapper implements ReverseMapper<Product> {

	@Override
	public Map<String, Object> getEntityParameters(Product entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		map.put(Constants.TABLE_COLOMN_PRODUCT_NAME, entity.getName());
		map.put(Constants.TABLE_COLOMN_PRODUCT_NUMBER, entity.getNumber());
		map.put(Constants.TABLE_COLOMN_PRODUCT_STATUS, entity.getStatus());
		map.put(Constants.TABLE_COLOMN_PRODUCT_VERSION, entity.getVersion());
		map.put(Constants.TABLE_COLOMN_PRODUCT_UPDATE, entity.getUpdate());
		map.put(Constants.TABLE_COLOMN_PRODUCT_DESCRIPTION, entity.getDescription());
		map.put(Constants.TABLE_COLOMN_PRODUCT_DRAW_LINK, entity.getDrawLink());
		map.put(Constants.TABLE_COLOMN_PRODUCT_ASM_ID, entity.getAsmId());
		
		return map;
	}

}
