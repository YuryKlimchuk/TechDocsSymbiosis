package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.Entities.Buy;

@Component("BuyService")
public class BuyService extends BasicServiceForEntity<Buy> {
	
	@Autowired
	public BuyService(@Qualifier("BuyDAO") BasicDAOInterface<Buy, Long> entityDAO) {
		super(entityDAO, "buy");
	}

}
