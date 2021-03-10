package com.hydroyura.TechDocsSymbiosis.buy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component("BuyDaoImpl")
@Repository
public class BuyDaoImpl implements DaoInterface<BuyEntity> {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<BuyEntity> getAll() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_BUY + ";";
		return jdbc.query(query, new BuyRowMap());
	}

	@Override
	public BuyEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		String query;
		if(searchFilter.getStringElementFromMap("BUY_TYPE").equals("ALL_TYPES")) {
			query = "SELECT * FROM " + Constants.TABLE_NAME_BUY;
		} else {
			query = "SELECT * FROM " + Constants.TABLE_NAME_BUY + " WHERE " + Constants.TABLE_COLOMN_BUY_MANUFACTURER + " ='"
					+ searchFilter.getStringElementFromMap("BUY_TYPE") + "';";
		}
		return jdbc.query(query, new BuyRowMap());
	}

	@Override
	public boolean addItem(BuyEntity item) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_BUY + " (" 
				+ Constants.TABLE_COLOMN_BUY_NUMBER + ", " 
				+ Constants.TABLE_COLOMN_BUY_NAME + ", " 
				+ Constants.TABLE_COLOMN_BUY_MANUFACTURER + ") VALUES (?, ?, ?);";
		
		try {
			jdbc.update(query, item.getNumber(), item.getName(), item.getManufacturer());
			return true;
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public int addItemWithIdReturn(BuyEntity item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItemDeleted(BuyEntity item) {
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
		String query = "SELECT DISTINCT " + Constants.TABLE_COLOMN_BUY_MANUFACTURER + " FROM " + Constants.TABLE_NAME_BUY
				+ " ORDER BY " + Constants.TABLE_COLOMN_BUY_MANUFACTURER + ";";
		
		return jdbc.queryForList(query, String.class);	
	}

	@Override
	public List<BuyEntity> getAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyEntity> getAllFromTableByCreteria(String tableName, int creteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
