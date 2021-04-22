package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.Entities.Product;

@Component("ProductService")
public class ProductService extends BasicServiceForEntity<Product> {
	
	@Autowired
	public ProductService(@Qualifier("ProductDAO") BasicDAOInterface<Product, Long> entityDAO) {
		super(entityDAO, "product");
	}

}
