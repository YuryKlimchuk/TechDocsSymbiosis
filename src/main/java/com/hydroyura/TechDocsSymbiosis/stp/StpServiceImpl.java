package com.hydroyura.TechDocsSymbiosis.stp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;

@Component("StpServiceImpl")
@Service
public class StpServiceImpl implements ServiceInterface<StpEntity> {
	
	
	@Autowired
	@Qualifier("StpDaoImpl")
	private DaoInterface<StpEntity> dao;
	

	@Override
	public List<StpEntity> getAll() {
		return dao.getAll();
	}

	@Override
	public StpEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StpEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		return dao.getItemsBySearchFilter(searchFilter);
	}

	@Override
	public boolean addItem(StpEntity item) {
		return dao.addItem(item);
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, StpEntity newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Float> getFloatList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getStringList() {
		return dao.getStringList();
	}

	@Override
	public List<StpEntity> getAllFromTableByIntCreteria(String tableName, int creteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
