package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component("OppDaoImpl")
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
		
		String name = searchFilter.getStringElement(Constants.TABLE_COLOMN_OPP_NAME);
		String number = searchFilter.getStringElement(Constants.TABLE_COLOMN_OPP_NUMBER);
		
		query = query + " WHERE " + Constants.TABLE_COLOMN_OPP_NAME + " LIKE '%" + name + "%'";
		query = query + " AND " + Constants.TABLE_COLOMN_OPP_NUMBER + " LIKE '%" + number + "%'";
		
		boolean task = searchFilter.getStringElement("task") != null ? true : false;  
		boolean note = searchFilter.getStringElement("note") != null ? true : false;     
		boolean design = searchFilter.getStringElement("design") != null ? true : false;  
		
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
		query = query + ";";
		
		System.out.println("getItemsBySearchFilter2222: " + query);
		
		return jdbc.query(query, new OppRowMap());
	}

	@Override
	public boolean addItem(OppEntity item) {
		return false;
	}

	@Override
	public boolean deleteItemById(int id) {
		return false;
	}

	@Override
	public boolean changeItem(OppEntity oldItem, OppEntity newItem) {
		return false;
	}

}
