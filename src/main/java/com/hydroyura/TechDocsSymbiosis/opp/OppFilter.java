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
		addStringElement("name", "");
		addStringElement("number", "");
		addStringElement("task", "task");
		addStringElement("design", "design");
		addStringElement("note", "note");
	}

	@Override
	public void clear() {}

	@Override
	public String toString() {
		return "OppFilter [stringMap=" + stringMap + "]";
	}

	@Override
	public void addStringElement(String key, String value) {
		this.stringMap.put(key, value);
	}

	@Override
	public String getStringElement(String key) {
		return this.stringMap.get(key);
	}

}
