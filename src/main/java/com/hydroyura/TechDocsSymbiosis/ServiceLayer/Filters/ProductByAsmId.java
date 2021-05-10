package com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters;

import com.hydroyura.TechDocsSymbiosis.Entities.Product;

public class ProductByAsmId implements Filter<Product> {

	
	private Long asmId;
	
	public ProductByAsmId(Long asmId) {
		this.asmId = asmId;
	}
	
	@Override
	public boolean compare(Product entity) {
		return entity.getAsmId() == asmId;
	}

}
