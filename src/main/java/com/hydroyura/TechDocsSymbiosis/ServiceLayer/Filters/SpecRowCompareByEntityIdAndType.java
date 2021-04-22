package com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters;

import com.hydroyura.TechDocsSymbiosis.Entities.SpecificationRow;


/**
 * Фильтр для отбора сборок в каторые входит элемент
 * @autor Yury Klimchuk
*/
public class SpecRowCompareByEntityIdAndType implements Filter<SpecificationRow> {

	private String type;
	private long entityId;
	
	public SpecRowCompareByEntityIdAndType(String type, long entityId) {
		this.type = type;
		this.entityId = entityId;
	}

	@Override
	public boolean compare(SpecificationRow entity) {	
		return entity.getRowType().equals(type) && (entity.getElementId() == entityId);
	}

}
