package com.hydroyura.TechDocsSymbiosis.vzk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VzkServiceInterfaceImpl implements VzkServiceInterface {

	@Autowired
	private VzkDao vzkDao;
	
	@Override
	public List<Vzk> getVzkList() {
		return vzkDao.getVzkList();
	}

}
