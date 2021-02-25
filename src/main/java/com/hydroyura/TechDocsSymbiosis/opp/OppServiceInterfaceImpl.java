package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OppServiceInterfaceImpl implements OppServiceInterface {
	
	private OppDao oppDao;
	
	
	@Autowired
	public OppServiceInterfaceImpl(OppDao oppDao) {
		this.oppDao = oppDao;
	}
	

	@Override
	public List<Opp> getOppList() {
		return oppDao.getOppList();
	}


	@Override
	public List<Opp> getOppListByFilter(OppFilter oppFilter) {
		if(oppFilter != null) {
			return oppDao.getOppListByStatus(oppFilter.getStatus());
		} else {
			return oppDao.getOppList();
		}
		
	}


	@Override
	public Opp getOppById(int id) {
		return oppDao.getOppbyId(id);
	}

}
