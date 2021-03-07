package com.hydroyura.TechDocsSymbiosis.asm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;
import com.hydroyura.TechDocsSymbiosis.opp.OppRowMap;



@Component("AsmDaoImpl")
@Repository
public class AsmDaoImpl implements DaoInterface<AsmEntity> {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<AsmEntity> getAll() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ASM + ";";
		return jdbc.query(query, new AsmRowMap());
	}

	@Override
	public AsmEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsmEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(AsmEntity item) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM + " ("  
				+ Constants.TABLE_COLOMN_ASM_NAME + ", "
				+ Constants.TABLE_COLOMN_ASM_NUMBER + ", "
				+ Constants.TABLE_COLOMN_ASM_STATUS + ", "
				+ Constants.TABLE_COLOMN_ASM_VERSION + ", "
				+ Constants.TABLE_COLOMN_ASM_UPDATE + ") VALUES (?, ?, ?, ?, ?);";
			
		return jdbc.update(query, 
				item.getName(),
				item.getNumber(),
				item.getStatus(),
				item.getVersion(),
				item.getUpdate()) == 1 ? true : false;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItemDeleted(AsmEntity item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, AsmEntity newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Float> getFloatList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addItemWithIdReturn(AsmEntity item) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM + " ("  
				+ Constants.TABLE_COLOMN_ASM_NAME + ", "
				+ Constants.TABLE_COLOMN_ASM_NUMBER + ", "
				+ Constants.TABLE_COLOMN_ASM_STATUS + ", "
				+ Constants.TABLE_COLOMN_ASM_VERSION + ", "
				+ Constants.TABLE_COLOMN_ASM_UPDATE + ") VALUES (?, ?, ?, ?, ?);";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps =
		                connection.prepareStatement(query, new String[] {"id"});
		            ps.setString(1, item.getName());
		            ps.setString(2, item.getNumber());
		            ps.setString(3, item.getStatus());
		            ps.setString(4, item.getVersion());
		            ps.setString(5, item.getUpdate());
		            return ps;
		        }
		    },
		    keyHolder);


		return (int) keyHolder.getKey();
	}


	
}
