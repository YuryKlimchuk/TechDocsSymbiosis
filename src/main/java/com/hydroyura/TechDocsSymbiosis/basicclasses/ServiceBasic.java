package com.hydroyura.TechDocsSymbiosis.basicclasses;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.ItemMapper;
import com.hydroyura.TechDocsSymbiosis.data.DataAsm;

public abstract class ServiceBasic<T> {
	
	@Autowired
	@Qualifier("DaoBasic")
	protected DaoBasic dao;
	
	protected String TABLE_NAME;
	protected String TABLE_NAME2;
	protected RowMapper<T> rowMapper;
	protected RowMapper<DataAsm> rowMapper2; // статически заполнить
	protected ItemMapper<T> itemMapper;
	protected ItemMapper<DataAsm> itemMapper2; // статически заполнить

	public int deleteItem(int id) {
		return dao.deleteItemById(TABLE_NAME, id);
	}
	
	public List<T> getItemsByNameAndNumber(String NAME, String NUMBER) {
		return dao.getItemsByNameAndNumber(TABLE_NAME, NAME, NUMBER, rowMapper);
	}
	
	public List<T> getItems() {
		return dao.getAllFromTable(TABLE_NAME, rowMapper);
	}
	
	public T getItem(int id) {
		return dao.getItemById(TABLE_NAME, rowMapper, id);
	}

	public int addItem(T item) {
		Map<String, String> map = itemMapper.getValues(item);
		return dao.addItemWithIdReturn(TABLE_NAME, map);
	}
	
	public int updateItem(int id, T item) {
		Map<String, String> map = itemMapper.getValues(item);
		return dao.updateItem(TABLE_NAME, id, map);
	}
	
	public int updateItemByDoubleKey(int key1, int key2, DataAsm item) {
		Map<String, String> map = itemMapper2.getValues(item);
		return dao.updateItemByDoubleKey(TABLE_NAME2, key1, key2, map);
	}
	
	
	public List<T> getItemsByIntCriteria(String _TABLE_NAME, int CRITERIA, String CRITERIA_NAME, RowMapper<T> _rowMapper) {
		return dao.getItemsByintCriteria(_TABLE_NAME, _rowMapper, CRITERIA, CRITERIA_NAME);
	}

	
	public List<T> getItemsByIntCriteria(String _TABLE_NAME, int CRITERIA, String CRITERIA_NAME) {
		return this.getItemsByIntCriteria(_TABLE_NAME, CRITERIA, CRITERIA_NAME, this.rowMapper);
	}
	
	public int deleteItemByDoubleKey(String _TABLE_NAME, int key1, int key2, String NAME_KEY1, String NAME_KEY2) {
		return dao.deleteItemByDoubleKey(_TABLE_NAME, key1, key2, NAME_KEY1, NAME_KEY2);
	}
	
	public DataAsm getItemByDoubleKey(int key1, int key2) {
		return dao.getItemByDoubleKey(TABLE_NAME2, key1, key2, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, rowMapper2);
	}
	
	public DataAsm getItemInnerJoinByDoubleKey(int key1, int key2) {
		return dao.getItemInnerJoinByDoubleKey(
					TABLE_NAME, TABLE_NAME2, 
					Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, 
					Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, key1, key2, 
					rowMapper2);
	}
}

