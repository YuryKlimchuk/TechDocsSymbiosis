package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;

public class OringFilter implements SearchFilter{
	
	private Map<String, Float> floatMap = new HashMap<>();
	private Map<Float, Boolean> booleanMap = new HashMap<>();
	private List<Float> floatList = new ArrayList<>();
	
	public OringFilter() {}
	
	
	
	public List<Float> getFloatList() {
		return floatList;
	}



	public void setFloatList(List<Float> floatList) {
		this.floatList = floatList;
	}



	public Map<Float, Boolean> getBooleanMap() {
		return booleanMap;
	}



	public void setBooleanMap(Map<Float, Boolean> booleanMap) {
		this.booleanMap = booleanMap;
	}



	public Map<String, Float> getFloatMap() {
		return floatMap;
	}

	public void setFloatMap(Map<String, Float> floatMap) {
		this.floatMap = floatMap;
	}

	@Override
	public void clear() {}

	@Override
	public void addFloatElementInMap(String key, Float value) {
		floatMap.put(key, value);
	}

	@Override
	public Float getFloatElementFromMap(String key) {
		return floatMap.get(key);
	}

	









	@Override
	public String toString() {
		return "OringFilter [floatMap=" + floatMap + ", booleanMap=" + booleanMap + ", floatList=" + floatList + "]";
	}



	@Override
	public void addBooleanElementInMap(Float key, Boolean value) {
		booleanMap.put(key, value);		
	}



	@Override
	public Boolean getBooleanElementFromMap(Float key) {
		return booleanMap.get(key);
	}



	@Override
	public void addStringElementInMap(String key, String value) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String getStringElementFromMap(String key) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addFloatElementInList(Float value) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Float getFloatElementFromList(int index) {
		return floatList.get(index);
	}



	@Override
	public int getFloatListSize() {
		return floatList.size();
	}



	
	
	


}
