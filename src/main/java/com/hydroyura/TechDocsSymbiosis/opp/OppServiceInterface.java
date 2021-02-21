package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;

public interface OppServiceInterface {

	public List<Opp> getOppListByFilter(OppFilter oppFilter);
	public List<Opp> getOppList();
	public Opp getOppById(int id);
	
}
