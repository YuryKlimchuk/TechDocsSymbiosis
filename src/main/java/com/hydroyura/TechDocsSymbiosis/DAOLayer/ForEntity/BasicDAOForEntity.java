package com.hydroyura.TechDocsSymbiosis.DAOLayer.ForEntity;

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

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers.ReverseMapper;


/**
 * Имплементация интерфейса DAO для сущностей: OPP, ASM, VZK, STP, BUY, ORING 
 * @autor Yury Klimchuk
*/
abstract class BasicDAOForEntity<T> implements BasicDAOInterface<T, Long> {

	@Autowired
	private JdbcTemplate jdbc;
	
	
	protected String TABLE_NAME;
	
	/** 
	 * Маппер для перегона из БД в Java обьект
	 */
	protected RowMapper<T> mapper;
	
	/** 
	 * Реверсивный маппер для перегона из Java обьекта в БД
	 */
	protected ReverseMapper<T> revMapper;
	//-------------------------------------------------------------------
	
	
	
	@Override
	public List<T> getAllEntities() {
		String query = "SELECT * FROM " + TABLE_NAME + ";";
		return jdbc.query(query, mapper);	
	}

	@Override
	public T getEntity(Long id) {
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?;";
		return jdbc.queryForObject(query, mapper, id);	
	}
	
	//-------------------------------------------------------------------
	/**
	 * @return -1 если обновить объект не удалось.
	 */
	@Override
	public long update(Long id, T newEntity) {
		String query = "UPDATE " + TABLE_NAME + " SET ";
		Map<String, Object> map = revMapper.getEntityParameters(newEntity);
		for(String str : map.keySet()) {
			query = query + str + "=?,"; 
		}
		
		query = query.substring(0, query.length()-1);
		query = query + " WHERE id=" + id + ";";		
		
		try {
			return jdbc.update(query, map.values().toArray());
					
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	//-------------------------------------------------------------------
	/**
	 * @return -1 если удалить объект не удалось.
	 */
	@Override
	public long delete(Long id) {
		String query = "DELETE FROM " + TABLE_NAME + " WHERE id=?;";
		try {
			return jdbc.update(query, id);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	//-------------------------------------------------------------------
	/**
	 * @return -1 если добавить объект не удалось, иначе возращаем id добавленного элемента
	 */
	@Override
	public long addEntity(T entity) {
		String query = "INSERT INTO " + TABLE_NAME + " (";
		
		Map<String, Object> map = revMapper.getEntityParameters(entity);
		
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
			            	ps.setObject((i+1), map.values().toArray()[i]);
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

}
