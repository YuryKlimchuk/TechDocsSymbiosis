package com.hydroyura.TechDocsSymbiosis.stp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component("StpDaoImpl")
@Repository
public class StpDaoImpl implements DaoInterface<StpEntity>{
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<StpEntity> getAll() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_STP;
		return jdbc.query(query, new StpRowMap());
	}

	@Override
	public StpEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StpEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		String query;
		if(searchFilter.getStringElementFromMap("STP_TYPE").equals("ALL_TYPES")) {
			query = "SELECT * FROM " + Constants.TABLE_NAME_STP;
		} else {
			query = "SELECT * FROM " + Constants.TABLE_NAME_STP + " WHERE " + Constants.TABLE_COLOMN_STP_NAME + " ='"
					+ searchFilter.getStringElementFromMap("STP_TYPE") + "';";
		}
		return jdbc.query(query, new StpRowMap());
	}
	
	@Override
	public boolean addItem(StpEntity item) {
		
		String query = "INSERT INTO " + Constants.TABLE_NAME_STP + " (" 
				+ Constants.TABLE_COLOMN_STP_NUMBER + ", " 
				+ Constants.TABLE_COLOMN_STP_NAME + ", " 
				+ Constants.TABLE_COLOMN_STP_STANDART + ") VALUES (?, ?, ?);";
		
		try {
			jdbc.update(query, item.getNumber(), item.getName(), item.getStandart());
			return true;
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public int addItemWithIdReturn(StpEntity item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItemDeleted(StpEntity item) {
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
		String query = "SELECT DISTINCT " + Constants.TABLE_COLOMN_STP_NAME + " FROM " + Constants.TABLE_NAME_STP
				+ " ORDER BY " + Constants.TABLE_COLOMN_STP_NAME + ";";
		
		return jdbc.queryForList(query, String.class);	
	}

}
