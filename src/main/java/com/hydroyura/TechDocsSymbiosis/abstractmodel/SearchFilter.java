package com.hydroyura.TechDocsSymbiosis.abstractmodel;

public interface SearchFilter {
	
	public void clear();
	
	public void addStringElementInMap(String key, String value);
	public String getStringElementFromMap(String key);
	
	public void addFloatElementInMap(String key, Float value);
	public Float getFloatElementFromMap(String key);
	
	public void addBooleanElementInMap(Float key, Boolean value);
	public Boolean getBooleanElementFromMap(Float key);
	
	public void addFloatElementInList(Float value);
	public Float getFloatElementFromList(int index);
	
	public int getFloatListSize();

}
