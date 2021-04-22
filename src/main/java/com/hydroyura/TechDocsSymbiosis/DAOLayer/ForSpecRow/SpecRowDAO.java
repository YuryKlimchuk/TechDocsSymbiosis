package com.hydroyura.TechDocsSymbiosis.DAOLayer.ForSpecRow;

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

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers.MapperFactory;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers.ReverseMapper;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers.ReverseMapperFactory;
import com.hydroyura.TechDocsSymbiosis.Entities.SpecificationRow;

@Component("SpecRowDAO")
public class SpecRowDAO implements BasicDAOInterface<SpecificationRow, CompositeKeySpecRow> {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private String TABLE_NAME = Constants.TABLE_NAME_SPECIFICATION_ROWS;
	
	/** 
	 * Маппер для перегона из БД в Java обьект
	 */
	private RowMapper<SpecificationRow> mapper = MapperFactory.generateRowMap(Constants.ROW_MAPPER_SPEC);
	/** 
	 * Реверсивный маппер для перегона из Java обьекта в БД
	 */
	@SuppressWarnings("unused")
	private ReverseMapper<SpecificationRow> revMapper = ReverseMapperFactory.generateRowMap(Constants.ROW_MAPPER_SPEC);;
	//-------------------------------------------------------------------
	
	@Override
	public List<SpecificationRow> getAllEntities() {
		String query = "SELECT * FROM " + TABLE_NAME + ";";
		return jdbc.query(query, mapper);
	}

	@Override
	public SpecificationRow getEntity(CompositeKeySpecRow id) {
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=? AND asm_id_full=? AND type=?;";
		return jdbc.queryForObject(query, mapper, id.getId(), id.getAsmId(), id.getType());	
	}

	@Override
	public long update(CompositeKeySpecRow id, SpecificationRow newEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long delete(CompositeKeySpecRow id) {
		String query = "DELETE FROM " + TABLE_NAME + " WHERE id=? AND asm_id_full=? AND type=?;";
		try {
			return jdbc.update(query, id.getId(), id.getAsmId(), id.getType());
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	@Override
	public long addEntity(SpecificationRow entity) {
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
