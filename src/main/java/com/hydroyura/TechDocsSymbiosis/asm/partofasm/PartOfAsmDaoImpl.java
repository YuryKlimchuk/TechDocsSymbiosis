package com.hydroyura.TechDocsSymbiosis.asm.partofasm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

@Component("PartOfAsmDaoImpl")
@Repository
public class PartOfAsmDaoImpl implements DaoInterface<PartOfAsmEntity> {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<PartOfAsmEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartOfAsmEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartOfAsmEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(PartOfAsmEntity item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addItemWithIdReturn(PartOfAsmEntity item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItemDeleted(PartOfAsmEntity item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, PartOfAsmEntity newItem) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartOfAsmEntity> getAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartOfAsmEntity> getAllFromTableByCreteria(String tableName, int creteria) {
		String query = "SELECT *FROM " + tableName + " WHERE " + Constants.TABLE_COLOMN_COMPOSITION_ASM_ID + "=?;";
		return jdbc.query(query, new PartOfAsmRowMap(), creteria);
	}

}
