package com.hydroyura.TechDocsSymbiosis.product;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.ProductItemMap;
import com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers.ProductRowMap;

@Component("ProductService")
@Service
public class ProductService extends ServiceBasic<ProductEntity>{
	
	@PostConstruct
	public void init() {
		TABLE_NAME = Constants.TABLE_NAME_PRODUCT;
		rowMapper = new ProductRowMap();
		itemMapper = new ProductItemMap();
	}
	

}
