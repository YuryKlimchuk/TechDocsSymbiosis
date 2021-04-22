package com.hydroyura.TechDocsSymbiosis.Entities;

//Сущность которая хранит описание стандартных изделий
public class Stp {

	// Уникальный индификатор
	private long id;
	
	// Обозначение 
	private String number; 
	
	// Наименование
	private String name;
	
	// Стандарт
	private String standart;

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
	
	@Override
	public int hashCode() {
		return (int) this.id;
	}
		

}
