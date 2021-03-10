package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component("OppDaoImpl")
@Repository
public class OppDaoImpl implements DaoInterface<OppEntity> {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<OppEntity> getAll() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_OPP + ";";
		return jdbc.query(query, new OppRowMap());
	}

	@Override
	public OppEntity getItemById(int id) {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_OPP + " WHERE " + Constants.TABLE_COLOMN_OPP_ID + "=?;";
		return jdbc.queryForObject(query, new OppRowMap(), id);
	}

	@Override
	public List<OppEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		
		String query = "SELECT * FROM " + Constants.TABLE_NAME_OPP;
		
		String name = searchFilter.getStringElementFromMap(Constants.TABLE_COLOMN_OPP_NAME);
		String number = searchFilter.getStringElementFromMap(Constants.TABLE_COLOMN_OPP_NUMBER);
		
		query = query + " WHERE " + Constants.TABLE_COLOMN_OPP_NAME + " LIKE '%" + name + "%'";
		query = query + " AND " + Constants.TABLE_COLOMN_OPP_NUMBER + " LIKE '%" + number + "%'";
		
		boolean task = searchFilter.getStringElementFromMap("task") != null ? true : false;  
		boolean note = searchFilter.getStringElementFromMap("note") != null ? true : false;     
		boolean design = searchFilter.getStringElementFromMap("design") != null ? true : false;  
		
		if(task || note || design) {
			query = query + " AND " + Constants.TABLE_COLOMN_OPP_STATUS + " IN (";
			if(task) query = query + "'TASK',";
			if(note) query = query + "'NOTE',";
			if(design) query = query + "'DESIGN',";
			query = query.substring(0, query.length()-1);
			query = query + ")";
		} else {
			query = query + " AND " + Constants.TABLE_COLOMN_OPP_STATUS + " IN ('NULL')";
		}
		query = query + "ORDER BY " + Constants.TABLE_COLOMN_OPP_NUMBER + ";";
		
		System.out.println("getItemsBySearchFilter2222: " + query);
		
		return jdbc.query(query, new OppRowMap());
	}

	@Override
	public boolean addItem(OppEntity item) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_OPP + " ("  
				+ Constants.TABLE_COLOMN_OPP_NAME + ", "
				+ Constants.TABLE_COLOMN_OPP_NUMBER + ", "
				+ Constants.TABLE_COLOMN_OPP_STATUS + ", "
				+ Constants.TABLE_COLOMN_OPP_VERSION + ", "
				+ Constants.TABLE_COLOMN_OPP_UPDATE + ") VALUES (?, ?, ?, ?, ?);";
			
		return jdbc.update(query, 
				item.getName(),
				item.getNumber(),
				item.getStatus(),
				item.getVersion(),
				item.getUpdate()) == 1 ? true : false;
	}
	
	@Override
	public boolean addItemDeleted(OppEntity item) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_OPP_DELETED + " (" 
				+ Constants.TABLE_COLOMN_OPP_ID + ", " 
				+ Constants.TABLE_COLOMN_OPP_NAME + ", "
				+ Constants.TABLE_COLOMN_OPP_NUMBER + ", "
				+ Constants.TABLE_COLOMN_OPP_STATUS + ", "
				+ Constants.TABLE_COLOMN_OPP_VERSION + ", "
				+ Constants.TABLE_COLOMN_OPP_UPDATE + ") VALUES (?, ?, ?, ?, ?, ?);";
			
		return jdbc.update(query, 
				item.getId(),
				item.getName(),
				item.getNumber(),
				item.getStatus(),
				item.getVersion(),
				item.getUpdate()) == 1 ? true : false;
	}
	
	@Override
	public boolean deleteItemById(int id) {
		//addItemDeleted(getItemById(id));
		String query = "DELETE FROM " + Constants.TABLE_NAME_OPP + " WHERE " + Constants.TABLE_COLOMN_OPP_ID + "=?;";
		return jdbc.update(query, id) == 1 ? true : false;
	}

	@Override
	public boolean changeItem(int id, OppEntity newItem) {
		
		String query = "UPDATE " + Constants.TABLE_NAME_OPP + " SET " 
				+ Constants.TABLE_COLOMN_OPP_NAME + " =?, " 
				+ Constants.TABLE_COLOMN_OPP_NUMBER + " =?, " 
				+ Constants.TABLE_COLOMN_OPP_STATUS + " =?, " 
				+ Constants.TABLE_COLOMN_OPP_VERSION + " =?, " 
				+ Constants.TABLE_COLOMN_OPP_UPDATE + " =? WHERE "
				+ Constants.TABLE_COLOMN_OPP_ID + "=?;";
		
		return jdbc.update(query, 
				newItem.getName(), 
				newItem.getNumber(),
				newItem.getStatus(),
				newItem.getVersion(),
				newItem.getUpdate(),
				id) == 1 ? true : false;
	}

	@Override
	public List<Float> getFloatList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addItemWithIdReturn(OppEntity item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getStringList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OppEntity> getAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OppEntity> getAllFromTableByCreteria(String tableName, int creteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
