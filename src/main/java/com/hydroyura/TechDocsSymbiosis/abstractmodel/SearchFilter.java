package com.hydroyura.TechDocsSymbiosis.abstractmodel;

public interface SearchFilter {
	
	public void clear();
	
	public void addStringElement(String key, String value);
	public String getStringElement(String key);
	

}
