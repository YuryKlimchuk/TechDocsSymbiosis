package com.hydroyura.TechDocsSymbiosis.vzk;

import java.util.HashMap;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;

public class VzkFilter implements SearchFilter {

	private Map<String, String> stringMap = new HashMap<String, String>();

	@Override
	public void clear() {}

	@Override
	public void addStringElementInMap(String key, String value) {
		stringMap.put(key, value);
	}

	@Override
	public String getStringElementFromMap(String key) {
		return stringMap.get(key);
	}

	@Override
	public void addFloatElementInMap(String key, Float value) {}

	@Override
	public Float getFloatElementFromMap(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBooleanElementInMap(Float key, Boolean value) {}

	@Override
	public Boolean getBooleanElementFromMap(Float key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFloatElementInList(Float value) {}

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

	public Map<String, String> getStringMap() {
		return stringMap;
	}

	public void setStringMap(Map<String, String> stringMap) {
		this.stringMap = stringMap;
	}

}
