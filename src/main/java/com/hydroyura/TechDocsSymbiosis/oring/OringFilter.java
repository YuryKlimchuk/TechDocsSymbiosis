package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;

public class OringFilter {
	
	private float maxInnerDiameter, minInnerDiameter;
	private List<Float> crossSectionListSelected;
	
	public OringFilter() {}
	
	public float getMaxInnerDiameter() {
		return maxInnerDiameter;
	}
	
	public float getMinInnerDiameter() {
		return minInnerDiameter;
	}

	public List<Float> getCrossSectionListSelected() {
		return crossSectionListSelected;
	}
	
	public void setMaxInnerDiameter(float maxInnerDiameter) {
		this.maxInnerDiameter = maxInnerDiameter;
	}
	
	public void setMinInnerDiameter(float minInnerDiameter) {
		this.minInnerDiameter = minInnerDiameter;
	}

	public void setCrossSectionListSelected(List<Float> crossSectionListSelected) {
		this.crossSectionListSelected = crossSectionListSelected;
	} 
	
	
	
	
	
	
	
	

}
