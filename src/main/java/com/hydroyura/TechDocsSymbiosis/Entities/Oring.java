package com.hydroyura.TechDocsSymbiosis.Entities;


// Сущность которая хранит описание детали собственного производства
public class Oring {
	
	
	// Уникальный индификатор
	private long id;
	
	// Обозначение 
	private String number; 
	
	// Наименование
	private String name;
	
	// Стандарт
	private String standart;
	
	// Поперечное сечение, мм
	private float crossSection;
	
	// Внутренний диаметр, мм
	private float innerDiameter;

	public long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getStandart() {
		return standart;
	}

	public float getCrossSection() {
		return crossSection;
	}

	public float getInnerDiameter() {
		return innerDiameter;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStandart(String standart) {
		this.standart = standart;
	}

	public void setCrossSection(float crossSection) {
		this.crossSection = crossSection;
	}

	public void setInnerDiameter(float innerDiameter) {
		this.innerDiameter = innerDiameter;
	}
	
	@Override
	public int hashCode() {
		return (int) this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Oring item = (Oring) obj;
		return this.id==item.id;
	}

}
