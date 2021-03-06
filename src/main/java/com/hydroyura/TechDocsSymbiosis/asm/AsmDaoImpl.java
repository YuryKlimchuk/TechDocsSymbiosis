package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;

@Component("AsmDaoImpl")
@Repository
public class AsmDaoImpl implements DaoInterface<AsmEntity> {

	@Autowired
	private JdbcTemplate jdbc;
	
	
	@Override
	public List<AsmEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AsmEntity getItemById(int id) {
		
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
	public boolean addItemDeleted(AsmEntity item) {
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
