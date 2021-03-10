package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;


@Component("OppServiceImpl")
@Service
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
		return dao.getItemsBySearchFilter(searchFilter);
	}

	@Override
	public boolean addItem(OppEntity item) {
		return dao.addItem(item);
	}

	@Override
	public boolean deleteItemById(int id) {
		return dao.deleteItemById(id);
	}

	@Override
	public boolean changeItem(int id, OppEntity newItem) {
		return dao.changeItem(id, newItem);
	}

	@Override
	public List<Float> getFloatList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getStringList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OppEntity> getAllFromTableByIntCreteria(String tableName, int creteria) {
		// TODO Auto-generated method stub
		return null;
	}



}
