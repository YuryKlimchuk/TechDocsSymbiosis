package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;

@Component("AsmService")
public class AsmService extends BasicServiceForEntity<Asm> {
	
	@Autowired
	public AsmService(@Qualifier("AsmDAO") BasicDAOInterface<Asm, Long> entityDAO) {
		super(entityDAO, "asm");
	}

}
