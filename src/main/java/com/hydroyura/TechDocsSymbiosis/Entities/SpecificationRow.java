package com.hydroyura.TechDocsSymbiosis.Entities;

// Сущность для описания строчки в спецификации
// Составной ключ для этой сущности: {asmId, elementId, rowType}.
public class SpecificationRow {
	
	// уникальный индификатор сборочной единицы
	private long asmId;
	
	// уникальный индификатор елемента образующего строку
	private long elementId;
	
	// количество элементов в данной строке
	private long count; 
	
	// имеет ли лемент замену, по умолчанию -1 (нет замены), в случае мдругих значений, элемент может быть взаимо заменяемый в другим с таким же значением
	private long change;

	// раздел спецификации куда входит строка: OPP VZK ASM BUY STP ORING
	private String rowType;

	public long getAsmId() {
		return asmId;
	}

	public long getElementId() {
		return elementId;
	}

	public long getCount() {
		return count;
	}

	public long getChange() {
		return change;
	}

	public String getRowType() {
		return rowType;
	}

	public void setAsmId(long asmId) {
		this.asmId = asmId;
	}

	public void setElementId(long elementId) {
		this.elementId = elementId;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public void setChange(long change) {
		this.change = change;
	}

	public void setRowType(String rowType) {
		this.rowType = rowType;
	}

}
