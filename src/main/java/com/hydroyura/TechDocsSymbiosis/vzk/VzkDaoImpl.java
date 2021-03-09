package com.hydroyura.TechDocsSymbiosis.vzk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;
import com.hydroyura.TechDocsSymbiosis.opp.OppRowMap;
import com.hydroyura.TechDocsSymbiosis.stp.StpEntity;
import com.hydroyura.TechDocsSymbiosis.stp.StpRowMap;


@Component("VzkDaoImpl")
@Repository
public class VzkDaoImpl implements DaoInterface<VzkEntity> {

	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	@Override
	public List<VzkEntity> getAll() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_VZK + ";";
		return jdbc.query(query, new VzkRowMap());
	}

	@Override
	public VzkEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VzkEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		String query;
		if(searchFilter.getStringElementFromMap("VZK_TYPE").equals("ALL_TYPES")) {
			query = "SELECT * FROM " + Constants.TABLE_NAME_VZK;
		} else {
			query = "SELECT * FROM " + Constants.TABLE_NAME_VZK + " WHERE " + Constants.TABLE_COLOMN_VZK_NAME + " ='"
					+ searchFilter.getStringElementFromMap("VZK_TYPE") + "';";
		}
		return jdbc.query(query, new VzkRowMap());
	}

	@Override
	public boolean addItem(VzkEntity item) {
		
		String query = "INSERT INTO " + Constants.TABLE_NAME_VZK + " (" 
				+ Constants.TABLE_COLOMN_VZK_NUMBER + ", " 
				+ Constants.TABLE_COLOMN_VZK_NAME + ") VALUES (?, ?);";
		
		try {
			jdbc.update(query, item.getNumber(), item.getName());
			return true;
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public int addItemWithIdReturn(VzkEntity item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItemDeleted(VzkEntity item) {
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
		String query = "SELECT DISTINCT " + Constants.TABLE_COLOMN_VZK_NAME + " FROM " + Constants.TABLE_NAME_VZK
				+ " ORDER BY " + Constants.TABLE_COLOMN_VZK_NAME + ";";
		
		return jdbc.queryForList(query, String.class);	
	}

}
