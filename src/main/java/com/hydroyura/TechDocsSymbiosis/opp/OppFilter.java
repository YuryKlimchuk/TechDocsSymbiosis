package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;

public class OppFilter implements SearchFilter{
	
	private Map<String, String> stringMap = new HashMap<String, String>();
	
	

	public Map<String, String> getStringMap() {
		return stringMap;
	}

	public void setStringMap(Map<String, String> stringMap) {
		this.stringMap = stringMap;
	}

	public OppFilter() {
		System.out.println("oppFilter");
		addStringElementInMap("name", "");
		addStringElementInMap("number", "");
		addStringElementInMap("task", "task");
		addStringElementInMap("design", "design");
		addStringElementInMap("note", "note");
	}

	@Override
	public void clear() {}

	@Override
	public String toString() {
		return "OppFilter [stringMap=" + stringMap + "]";
	}

	@Override
	public void addStringElementInMap(String key, String value) {
		this.stringMap.put(key, value);
	}

	@Override
	public String getStringElementFromMap(String key) {
		return this.stringMap.get(key);
	}

	@Override
	public void addFloatElementInMap(String key, Float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Float getFloatElementFromMap(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBooleanElementInMap(Float key, Boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getBooleanElementFromMap(Float key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFloatElementInList(Float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Float getFloatElementFromList(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFloatListSize() {
		// TODO Auto-generated method stub
		return 0;
	}




}
