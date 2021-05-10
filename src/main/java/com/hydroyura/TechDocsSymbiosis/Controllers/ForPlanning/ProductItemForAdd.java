package com.hydroyura.TechDocsSymbiosis.Controllers.ForPlanning;

// Служебный класс для формы добавления единицы продукции
public class ProductItemForAdd {
	
	// id сборки
	private Long asmId;
	
	// Количество
	private Long count;

	
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getAsmId() {
		return asmId;
	}

	public void setAsmId(Long asmId) {
		this.asmId = asmId;
	}

	
}


