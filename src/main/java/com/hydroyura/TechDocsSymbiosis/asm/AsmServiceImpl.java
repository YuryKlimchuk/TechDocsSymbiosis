package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;
import com.hydroyura.TechDocsSymbiosis.opp.OppServiceImpl;

@Component("AsmServiceImpl")
@Service
public class AsmServiceImpl implements ServiceInterface<AsmEntity> {
	
	@Autowired
	private OppServiceImpl oppService;

	
	@Autowired
	@Qualifier("AsmDaoImpl")
	private DaoInterface<AsmEntity> dao;
	
	
	public List<OppEntity> getAllOpp() {
		return oppService.getAll();
	}
	
	@Override
	public List<AsmEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AsmEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsmEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(AsmEntity item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, AsmEntity newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Float> getFloatList() {
		// TODO Auto-generated method stub
		return null;
	}

}
