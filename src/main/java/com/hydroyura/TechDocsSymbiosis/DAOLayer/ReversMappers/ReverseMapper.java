package com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers;

import java.util.Map;

public interface ReverseMapper<T> {
	
	// key - название поля сущности, value - значение поля сущности
	public Map<String, Object> getEntityParameters(T entity); 

}
