package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.Entities.Stp;

@Component("StpService")
public class StpService extends BasicServiceForEntity<Stp> {
	
	@Autowired
	public StpService(@Qualifier("StpDAO") BasicDAOInterface<Stp, Long> entityDAO) {
		super(entityDAO, "stp");
	}

}
