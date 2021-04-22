package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.Entities.Oring;

@Component("OringService")
public class OringService extends BasicServiceForEntity<Oring> {
	
	@Autowired
	public OringService(@Qualifier("OringDAO") BasicDAOInterface<Oring, Long> entityDAO) {
		super(entityDAO, "oring");
	}

}
