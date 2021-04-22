package com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters;

public interface Filter<T> {
	
	public boolean compare(T entity);

}
