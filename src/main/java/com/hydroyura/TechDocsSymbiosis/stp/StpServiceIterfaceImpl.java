package com.hydroyura.TechDocsSymbiosis.stp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StpServiceIterfaceImpl implements StpServiceInterface {
	
	
	private StpDao stpDao;

	
	@Autowired
	public StpServiceIterfaceImpl(StpDao stpDao) {
		this.stpDao = stpDao;
	}


	@Override
	public List<Stp> getListStp() {
		return stpDao.getStpList();
	}
	
	
	
	
	

}
