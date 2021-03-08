package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component("OringDaoImpl")
@Repository
public class OringDaoImpl implements DaoInterface<OringEntity> {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<OringEntity> getAll() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS + ";";
		return jdbc.query(query, new OringRowMap());
	}

	@Override
	public OringEntity getItemById(int id) {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS + " WHERE " + Constants.TABLE_COLOMN_ORINGS_ID + "=?;";
		return jdbc.queryForObject(query, new OringRowMap(), id);
	}

	@Override
	public List<OringEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		String query;
		if(searchFilter.getFloatElementFromMap("min") != searchFilter.getFloatElementFromMap("max")) {
			query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS 
					+ " WHERE " + Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + " BETWEEN "
					+ searchFilter.getFloatElementFromMap("min") + " AND " + searchFilter.getFloatElementFromMap("max")
					+ " AND " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + " IN(";
		} else {
			query = "SELECT * FROM " + Constants.TABLE_NAME_ORINGS 
					+ " WHERE " + Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + " BETWEEN 0 AND 1000"
					+ " AND " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + " IN(";
		}	
		
		if(searchFilter.getFloatListSize() != 0) {
			for(int i = 0; i < searchFilter.getFloatListSize(); i ++) {
				query = query + "'" + searchFilter.getFloatElementFromList(i) + "',";
			}
			
			query = query.substring(0, query.length()-1);
			query = query + ")";
			
		} else {
			query = query + "'-1')";
		}
		query = query + ";";
		
		System.out.println("getItemsBySearchFilter: " + query);
		
		return jdbc.query(query, new OringRowMap());
	}

	@Override
	public boolean addItem(OringEntity item) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ORINGS + " (" 
				+ Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + ", " 
				+ Constants.TABLE_COLOMN_ORINGS_NAME + ", " 
				+ Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + ", " 
				+ Constants.TABLE_COLOMN_ORINGS_NUMBER + ", " 
				+ Constants.TABLE_COLOMN_ORINGS_STANDART + ") VALUES (?, ?, ?, ?, ?);";
				
		return jdbc.update(query, 
				item.getCrossSection(), 
				item.getName(),
				item.getInnerDiameter(),
				item.getNumber(),
				item.getStandart())  == 1 ? true : false;
	}

	@Override
	public boolean deleteItemById(int id) {
		//addItemDeleted(getItemById(id));
		String query = "DELETE FROM " + Constants.TABLE_NAME_ORINGS + " WHERE " + Constants.TABLE_COLOMN_ORINGS_ID + "=?;";
		return jdbc.update(query, id) == 1 ? true : false;
	}

	@Override
	public boolean addItemDeleted(OringEntity item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, OringEntity newItem) {
		String query = "UPDATE " + Constants.TABLE_NAME_ORINGS + " SET " 
				+ Constants.TABLE_COLOMN_ORINGS_NAME + " =?, " 
				+ Constants.TABLE_COLOMN_ORINGS_NUMBER + " =?, " 
				+ Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + " =?, " 
				+ Constants.TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER + " =?, " 
				+ Constants.TABLE_COLOMN_ORINGS_STANDART + " =? WHERE "
				+ Constants.TABLE_COLOMN_ORINGS_ID + "=?;";
		return jdbc.update(query, 
				newItem.getName(), 
				newItem.getNumber(),
				newItem.getCrossSection(),
				newItem.getInnerDiameter(),
				newItem.getStandart(),
				id) == 1 ? true : false;
	}

	@Override
	public List<Float> getFloatList() {
		String query = "SELECT DISTINCT " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + " FROM " + Constants.TABLE_NAME_ORINGS 
				+ " ORDER BY " + Constants.TABLE_COLOMN_ORINGS_CROSS_SECTION + ";";
		
		return jdbc.queryForList(query, Float.class);	
	}

	@Override
	public int addItemWithIdReturn(OringEntity item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getStringList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
