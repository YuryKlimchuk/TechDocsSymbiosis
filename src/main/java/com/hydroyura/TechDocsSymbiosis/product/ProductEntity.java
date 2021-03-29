package com.hydroyura.TechDocsSymbiosis.product;

public class ProductEntity {
	
	
	private String name, number;
	private String description;
	private String drawLink;
	private int asmId;
	private int id;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDrawLink() {
		return drawLink;
	}
	public void setDrawLink(String drawLink) {
		this.drawLink = drawLink;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAsmId() {
		return asmId;
	}
	public void setAsmId(int asmId) {
		this.asmId = asmId;
	}

}
