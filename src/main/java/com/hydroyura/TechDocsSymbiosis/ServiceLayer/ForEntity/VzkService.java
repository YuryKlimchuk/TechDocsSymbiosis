package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;

@Component("VzkService")
public class VzkService extends BasicServiceForEntity<Vzk> {
	
	@Autowired
	public VzkService(@Qualifier("VzkDAO") BasicDAOInterface<Vzk, Long> entityDAO) {
		super(entityDAO, "vzk");
	}

}
