	package com.hydroyura.TechDocsSymbiosis.basicclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	
	
	public <T> T getItemById(String TABLE_NAME, RowMapper<T> mapper, long id) {
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?;";
		return jdbc.queryForObject(query, mapper, id);	
	}
	
	public long deleteItemById(String TABLE_NAME, long id) {
		String query = "DELETE FROM " + TABLE_NAME + " WHERE id=?;";
		try {
			return jdbc.update(query, id);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
		
	}

	public <T> List<T> getItemsByLongCriteria(String TABLE_NAME, RowMapper<T> mapper, long CRITERIA, String CRITERIA_NAME) {
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + CRITERIA_NAME + "=?;";
		return jdbc.query(query, mapper, CRITERIA);	
	}
	
	public <T> long addItemWithIdReturn(String TABLE_NAME, Map<String, String> map) {
		
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
			return (int) keyHolder.getKey();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	public <T> long updateItem(String TABLE_NAME, long editItemId, Map<String, String> map) {
		
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

	public <T> List<T> getItemsByNameAndNumber(String TABLE_NAME, String NAME, String NUMBER, RowMapper<T> mapper) {
		
		String query = "SELECT * FROM " + TABLE_NAME;

		query = query + " WHERE " + Constants.TABLE_COLOMN_OPP_NAME + " LIKE '%" + NAME + "%'";
		query = query + " AND " + Constants.TABLE_COLOMN_OPP_NUMBER + " LIKE '%" + NUMBER + "%';";

		return jdbc.query(query, mapper);
	}

}
