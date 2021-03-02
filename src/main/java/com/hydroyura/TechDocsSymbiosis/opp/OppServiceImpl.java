package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;


@Component("OppServiceImpl")
public class OppServiceImpl implements ServiceInterface<OppEntity>{

	@Autowired
	@Qualifier("OppDaoImpl")
	private DaoInterface<OppEntity> dao;
	
	@Override
	public List<OppEntity> getAll() {
		return dao.getAll();
	}

	@Override
	public OppEntity getItemById(int id) {
		return dao.getItemById(id);
	}

	@Override
	public List<OppEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		System.out.println("SERVICE");
		return dao.getItemsBySearchFilter(searchFilter);
	}

	@Override
	public boolean addItem(OppEntity item) {
		return false;
	}

	@Override
	public boolean deleteItemById(int id) {
		return false;
	}

	@Override
	public boolean changeItem(OppEntity oldItem, OppEntity newItem) {
		return false;
	}

}
