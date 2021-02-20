package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;

public interface OringServiceInterface {
	
	public List<Oring> getOringList();
	public Oring getOringItem(int id);
	public List<Float> getCrossSectionList();
	public List<Oring> getOringListByFilter(OringFilter oringFilter);
	public float getMaxInnerDiameter();
	public float getMinInnerDiameter();

}
