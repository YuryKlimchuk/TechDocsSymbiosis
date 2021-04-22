package com.hydroyura.TechDocsSymbiosis.Entities;

//Сущность которая хранит описание ведомостей взаимозаменяемых комплектующих
public class Vzk {
	
	// Уникальный индификатор
	private long id;
	
	// Обозначение 
	private String number; 
	
	// Наименование
	private String name;

	public long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
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
	
	@Override
	public boolean equals(Object obj) {
		Vzk vzk = (Vzk) obj;
		return this.id==vzk.id;
	}
	
	@Override
	public int hashCode() {
		return (int) this.id;
	}
}
