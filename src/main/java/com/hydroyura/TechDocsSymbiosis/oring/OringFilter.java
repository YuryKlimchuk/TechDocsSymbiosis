package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;

public class OringFilter {
	
	private float maxInnerDiameter, minInnerDiameter, maxInnerDiameterDefault, minInnerDiameterDefault;
	private List<Float> crossSectionListSelected;
	
	public float getMaxInnerDiameter() {
		return maxInnerDiameter;
	}
	public float getMinInnerDiameter() {
		return minInnerDiameter;
	}
	public float getMaxInnerDiameterDefault() {
		return maxInnerDiameterDefault;
	}
	public float getMinInnerDiameterDefault() {
		return minInnerDiameterDefault;
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
	public void setMaxInnerDiameterDefault(float maxInnerDiameterDefault) {
		this.maxInnerDiameterDefault = maxInnerDiameterDefault;
	}
	public void setMinInnerDiameterDefault(float minInnerDiameterDefault) {
		this.minInnerDiameterDefault = minInnerDiameterDefault;
	}

	public void setCrossSectionListSelected(List<Float> crossSectionListSelected) {
		this.crossSectionListSelected = crossSectionListSelected;
	} 
	
	
	
	
	
	
	
	

}
