package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.Entities.Opp;

@Component("OppService")
public class OppService extends BasicServiceForEntity<Opp> {
	
	@Autowired
	public OppService(@Qualifier("OppDAO") BasicDAOInterface<Opp, Long> entityDAO) {
		super(entityDAO, "opp");
	}

}
