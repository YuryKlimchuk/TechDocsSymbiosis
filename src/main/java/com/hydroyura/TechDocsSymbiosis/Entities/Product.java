package com.hydroyura.TechDocsSymbiosis.Entities;

public class Product {
	
	private long id, asmId;
	private String number, name, description, status, version, update, drawLink;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAsmId() {
		return asmId;
	}
	public void setAsmId(long asmId) {
		this.asmId = asmId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getDrawLink() {
		return drawLink;
	}
	public void setDrawLink(String drawLink) {
		this.drawLink = drawLink;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", asmId=" + asmId + ", number=" + number + ", name=" + name + ", description="
				+ description + ", status=" + status + ", version=" + version + ", update=" + update + ", drawLink="
				+ drawLink + "]";
	}


	@Override
	public int hashCode() {
		return (int) this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Product item = (Product) obj;
		return this.id==item.id;
	}
	

}
