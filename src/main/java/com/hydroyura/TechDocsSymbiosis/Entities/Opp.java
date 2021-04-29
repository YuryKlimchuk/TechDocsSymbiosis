package com.hydroyura.TechDocsSymbiosis.Entities;

/**
 * Сущность которая хранит описание детали собственного производства
 * @autor Yury Klimchuk
 */
public class Opp {
	
	/** Уникальный индификатор (ID)*/
	private long id;
	
	/** Обозначение*/ 
	private String number; 
	
	/** Наименование*/
	private String name;
	
	/** Статус, принимает значения DESIGN (разработка), TASK (задание на изготовление), NOTE (извещение)*/
	private String status;
	
	/** Номер извещения или задания*/
	private String version;
	
	/** Дата последнего обновления*/
	private String update;

	public long getId() {
		return id;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Override
	public int hashCode() {
		return (int) this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Opp item = (Opp) obj;
		return this.id==item.id;
	}
}
