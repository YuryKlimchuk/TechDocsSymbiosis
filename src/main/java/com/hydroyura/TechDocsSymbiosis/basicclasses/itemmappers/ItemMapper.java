package com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers;

import java.util.Map;

@FunctionalInterface
public interface ItemMapper<T> {
	public Map<String, String> getValues (T item);
}



