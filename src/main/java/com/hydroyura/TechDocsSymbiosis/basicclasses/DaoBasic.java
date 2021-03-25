	package com.hydroyura.TechDocsSymbiosis.basicclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("DaoBasic")
@Repository
public class DaoBasic {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public <T> List<T> getAllFromTable(String TABLE_NAME, RowMapper<T> mapper) {
		String query = "SELECT * FROM " + TABLE_NAME + ";";
		return jdbc.query(query, mapper);	
	}
	
	
	public <T> T getItemById(String TABLE_NAME, RowMapper<T> mapper, int id) {
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?;";
		return jdbc.queryForObject(query, mapper, id);	
	}
	
	public int deleteItemById(String TABLE_NAME, int id) {
		String query = "DELETE FROM " + TABLE_NAME + " WHERE id=?;";
		try {
			return jdbc.update(query, id);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
		
	}

	public <T> List<T> getItemsByintCriteria(String TABLE_NAME, RowMapper<T> mapper, int CRITERIA, String CRITERIA_NAME) {
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + CRITERIA_NAME + "=?;";
		return jdbc.query(query, mapper, CRITERIA);	
	}
	
	public <T> int addItemWithIdReturn(String TABLE_NAME, Map<String, String> map) {
		
		String query = "INSERT INTO " + TABLE_NAME + " (";
		
		
		for(String str : map.keySet()) {
			query = query + str + ","; 
		}
		
		query = query.substring(0, query.length()-1);
		query = query + ") VALUES (";
		
		for(int i = 0; i < map.size(); i++) {
			query = query + "?,";
		}
		
		query = query.substring(0, query.length()-1);
		query = query + ");";
		
		final String str = new String(query);
		System.out.println("2");
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbc.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(str, new String[] {"id"});
			            for(int i = 0; i < map.size(); i++)
			            	ps.setString((i+1), (String) map.values().toArray()[i]);
			            return ps;
			        }
			    },
			    keyHolder);
			System.out.println("3");
			return (int) keyHolder.getKey();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
/*
	
	public <T> int addItem(String TABLE_NAME, Map<String, String> map) {
		//Безопасный метод (но не работае, возможно нужно добавить '?')
		String query = "INSERT INTO " + TABLE_NAME + " (";
		
		
		for(String str : map.keySet()) {
			query = query + str + ","; 
		}
		
		query = query.substring(0, query.length()-1);
		query = query + ") VALUES (";
		
		for(int i = 0; i < map.size(); i++) {
			query = query + "?,";
		}
		
		query = query.substring(0, query.length()-1);
		query = query + ");";
		
		System.out.println("2");
		try {
			
			System.out.println("3");
			
			System.out.println(map.values().);
			
			return jdbc.update(query, map.values().toArray());
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
*/
	public <T> int addItem(String TABLE_NAME, Map<String, String> map) {
		// переделать на безопастный метод
		String query = "INSERT INTO " + TABLE_NAME + " (";
		
		
		for(String str : map.keySet()) {
			query = query + str + ","; 
		}
		
		query = query.substring(0, query.length()-1);
		query = query + ") VALUES (";
		
		for(String str : map.values()) {
			query = query + str + ",";
		}
		
		query = query.substring(0, query.length()-1);
		query = query + ");";
		
		System.out.println("2");
		try {
			
			System.out.println("3");
			
			System.out.println(map.values());
			
			return jdbc.update(query);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	
	public <T> int updateItem(String TABLE_NAME, int editItemId, Map<String, String> map) {
		
		String query = "UPDATE " + TABLE_NAME + " SET ";
		for(String str : map.keySet()) {
			query = query + str + "=?,"; 
		}
		
		query = query.substring(0, query.length()-1);
		query = query + " WHERE id=" + editItemId + ";";		
		
		//System.out.println("updateItem, query = " + query);
		
		try {
			return jdbc.update(query, map.values().toArray());
					
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	
	
	/*
	public <T> int updateItem(String TABLE_NAME, int editItemId, Map<String, String> map) {
		
		String query = "UPDATE " + TABLE_NAME + " SET ";
		for(String str : map.keySet()) {
			query = query + str + "=?,"; 
		}
		
		query = query.substring(0, query.length()-1);
		query = query + " WHERE id=" + editItemId + ";";		
		
		final String str = new String(query);
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbc.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps = connection.prepareStatement(str, new String[] {"id"});
			            for(int i = 0; i < map.size(); i++)
			            	ps.setString((i+1), (String) map.values().toArray()[i]);
			            return ps;
			        }
			    },
			    keyHolder);
			return (int) keyHolder.getKey();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	*/
	
	
	// добавить проверку на содеражние такогоже элемента
	public <T> int updateItemByDoubleKey(String TABLE_NAME, int key1, int key2, Map<String, String> map) {
		
		String query = "UPDATE " + TABLE_NAME + " SET ";
		
		// using for-each loop for iteration over Map.entrySet() 
		
		List<Integer> paramentrs = new ArrayList<Integer>();
        for (Map.Entry<String,String> entry : map.entrySet())   {
			query = query + entry.getKey() + "=?, ";
			paramentrs.add(Integer.valueOf(entry.getValue()));
		}
		
		query = query.substring(0, query.length()-2);
		query = query + " WHERE id=? AND asm_id_full=?;";		
		
		

		
		paramentrs.add((int) key1);
		paramentrs.add((int) key2);
		
		//System.out.println(query);
		//System.out.println(paramentrs.toArray().toString());
		/*
		for (String string : paramentrs) {
			System.out.println("string = " + string);
		}
		*/
		
		try {
			return jdbc.update(query, paramentrs.toArray());
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	public <T> List<T> getItemsByNameAndNumber(String TABLE_NAME, String NAME, String NUMBER, RowMapper<T> mapper) {
		
		String query = "SELECT * FROM " + TABLE_NAME;

		query = query + " WHERE " + Constants.TABLE_COLOMN_OPP_NAME + " LIKE '%" + NAME + "%'";
		query = query + " AND " + Constants.TABLE_COLOMN_OPP_NUMBER + " LIKE '%" + NUMBER + "%';";

		return jdbc.query(query, mapper);
	}
	
	
	public <T> List<T> getItemsInnerJoinByintCriteria(
			String TABLE_NAME1, String TABLE_NAME2, 
			String COL_NAME1, String COL_NAME2,
			String CRITERIA_NAME, int CRITERIA_VALUE,
			RowMapper<T> _mapper) {
		
		String query = "SELECT * FROM " + TABLE_NAME1 + " INNER JOIN " + TABLE_NAME2 + " ON " + 
				TABLE_NAME1 + "." + COL_NAME1 + " = " + TABLE_NAME2 + "." + COL_NAME2 + 
				" WHERE " + CRITERIA_NAME + " = " + CRITERIA_VALUE;
		try {
			return jdbc.query(query, _mapper);
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public int deleteItemByDoubleKey(String TABLE_NAME, int key1, int key2, String NAME_KEY1, String NAME_KEY2) {
		String query = "DELETE FROM " + TABLE_NAME + " WHERE "
				+ NAME_KEY1 + "=? AND "
				+ NAME_KEY2 + "=?;";
		try {
			return jdbc.update(query, key1, key2);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public <T> T getItemByDoubleKey(String TABLE_NAME, int key1, int key2, String NAME_KEY1, String NAME_KEY2, RowMapper<T> mapper) {
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE "
				+ NAME_KEY1 + "=? AND "
				+ NAME_KEY2 + "=?;";
		try {
			return jdbc.queryForObject(query, mapper, key1, key2);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public <T> T getItemInnerJoinByDoubleKey(
			String TABLE_NAME1, String TABLE_NAME2,
			String COL_NAME1, String COL_NAME2,
			String NAME_KEY1, String NAME_KEY2,
			int key1, int key2, RowMapper<T> mapper) {
		
		String query = "SELECT * FROM " + TABLE_NAME1 + " INNER JOIN " + TABLE_NAME2 + " ON " + 
				TABLE_NAME1 + "." + COL_NAME1 + " = " + TABLE_NAME2 + "." + COL_NAME2 + " WHERE "
				+ TABLE_NAME2 + "." + COL_NAME2 + "=? AND "
				+ NAME_KEY2 + "=?;";
		//System.out.println(query);
		try {
			return jdbc.queryForObject(query, mapper, key1, key2);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	


}
