package com.hydroyura.TechDocsSymbiosis.basicclasses;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;

import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.ItemMapper;

public abstract class ServiceBasic<T> {
	
	@Autowired
	@Qualifier("DaoBasic")
	protected DaoBasic dao;
	
	protected String TABLE_NAME;
	protected RowMapper<T> rowMapper;
	protected ItemMapper<T> itemMapper;

	public long deleteItem(long id) {
		return dao.deleteItemById(TABLE_NAME, id);
	}
	
	public List<T> getItemsByNameAndNumber(String NAME, String NUMBER) {
		return dao.getItemsByNameAndNumber(TABLE_NAME, NAME, NUMBER, rowMapper);
	}
	
	public List<T> getItems() {
		return dao.getAllFromTable(TABLE_NAME, rowMapper);
	}
	
	public T getItem(long id) {
		return dao.getItemById(TABLE_NAME, rowMapper, id);
	}

	public long addItem(T item) {
		Map<String, String> map = itemMapper.getValues(item);
		return dao.addItemWithIdReturn(TABLE_NAME, map);
	}
	
	public long updateItem(long id, T item) {
		Map<String, String> map = itemMapper.getValues(item);
		return dao.updateItem(TABLE_NAME, id, map);
	}
	
	public List<T> getItemsByLongCriteria(String _TABLE_NAME, long CRITERIA, String CRITERIA_NAME) {
		return dao.getItemsByLongCriteria(_TABLE_NAME, rowMapper, CRITERIA, CRITERIA_NAME);
	}

}
