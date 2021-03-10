package com.hydroyura.TechDocsSymbiosis.buy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;

@Component("BuyServiceImpl")
@Service
public class BuyServiceImpl implements ServiceInterface<BuyEntity> {

	
	@Autowired
	@Qualifier("BuyDaoImpl")
	private BuyDaoImpl dao;
	
	
	
	@Override
	public List<BuyEntity> getAll() {
		return dao.getAll();
	}

	@Override
	public BuyEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		return dao.getItemsBySearchFilter(searchFilter);
	}

	@Override
	public boolean addItem(BuyEntity item) {
		return dao.addItem(item);
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, BuyEntity newItem) {
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
	public List<BuyEntity> getAllFromTableByIntCreteria(String tableName, int creteria) {
		// TODO Auto-generated method stub
		return null;
	}



}
