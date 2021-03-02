package com.hydroyura.TechDocsSymbiosis.abstractmodel;

import java.util.List;

public interface ServiceInterface<T> {
	
	public List<T> getAll();
	public T getItemById(int id);
	public List<T> getItemsBySearchFilter(SearchFilter searchFilter);
	public boolean addItem(T item);
	public boolean deleteItemById(int id);
	public boolean changeItem(T oldItem, T newItem);

}
