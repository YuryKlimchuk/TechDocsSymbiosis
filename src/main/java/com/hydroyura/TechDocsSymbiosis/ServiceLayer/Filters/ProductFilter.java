package com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters;

import org.apache.commons.lang3.StringUtils;

import com.hydroyura.TechDocsSymbiosis.Entities.Product;


/**
 * Фильтр для отбора деталей собственног опроизвоства (Oring), критерии: 
 * 	- статус (проектирование, извещение, задание на изготовление);
 *  - наименование и обозначение.
 * 
 * @autor Yury Klimchuk
*/
public class ProductFilter implements Filter<Product> {
	
	private String name="";
	private String number="";
	

	private boolean task = true;
	private boolean design = true;
	private boolean note = true;

	


	@Override
	public boolean compare(Product entity) {

		boolean nameFlag = true;
		if(!name.equals("")) {
			if(!StringUtils.containsIgnoreCase(entity.getName(), name)) 
				nameFlag = false;
		}
		
		boolean numberFlag = true;
		if(!number.equals("")) {
			if(!StringUtils.containsIgnoreCase(entity.getNumber(), number)) 
				numberFlag = false;
		}
		
		/*
		boolean statusFlag = false;
		String status = entity.getStatus();
		if(task && status.equals("TASK")) {
			statusFlag = true;
		}
		if(design && status.equals("DESIGN")) {
			statusFlag = true;
		}
		if(note && status.equals("NOTE")) {
			statusFlag = true;
		}
		*/
		return nameFlag && numberFlag;
	}

	
	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	

	public boolean getDesign() {
		return design;
	}

	public boolean getNote() {
		return note;
	}

	public void setDesign(boolean design) {
		this.design = design;
	}

	public void setNote(boolean note) {
		this.note = note;
	}

	public boolean getTask() {
		return task;
	}

	public void setTask(boolean task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "OppFilter [name=" + name + ", number=" + number + ", task=" + task + ", design=" + design + ", note="
				+ note + "]";
	}

	 

	
}
