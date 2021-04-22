package com.hydroyura.TechDocsSymbiosis.Entities;

// Сущность которая хранит описание сборочных единиц
public class Asm {
	
	// уникальный индификатор
	private long id;
	
	// Обозначение 
	private String number; 
	
	// Наименование
	private String name;
	
	// Статус, принимает значения DESIGN (разработка), TASK (задание на изготовление), NOTE (извещение)
	private String status;
	
	private String version;
	
	// Дата последнего обновления
	private String update;

	public long getId() {
		return id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getUpdate() {
		return update;
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

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	@Override
	public String toString() {
		return "Asm [id=" + id + ", number=" + number + ", name=" + name + ", status=" + status + ", version=" + version
				+ ", update=" + update + "]";
	}

	@Override
	public int hashCode() {
		return (int) this.id;
	}
	
}
