package com.hydroyura.TechDocsSymbiosis.opp;

public class OppEntity {
	
	private int id;
	private String number;
	private String name;
	private String status;
	private String version;
	private String update;
	
	public OppEntity() {}
	
	public int getId() {
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

	public String getVersion() {
		return version;
	}

	public String getUpdate() {
		return update;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "OppEntity [id=" + id + ", number=" + number + ", name=" + name + ", status=" + status + ", version="
				+ version + ", update=" + update + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setUpdate(String update) {
		this.update = update;
	}
}
