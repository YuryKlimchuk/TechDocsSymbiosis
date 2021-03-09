package com.hydroyura.TechDocsSymbiosis.vzk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;


@Component("VzkServiceImpl")
@Repository
public class VzkServiceImpl implements ServiceInterface<VzkEntity> {

	
	@Autowired
	@Qualifier("VzkDaoImpl")
	private DaoInterface<VzkEntity> dao;
	
	
	@Override
	public List<VzkEntity> getAll() {
		return dao.getAll();
	}

	@Override
	public VzkEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VzkEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		return dao.getItemsBySearchFilter(searchFilter);
	}

	@Override
	public boolean addItem(VzkEntity item) {
		return dao.addItem(item);
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, VzkEntity newItem) {
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

}
