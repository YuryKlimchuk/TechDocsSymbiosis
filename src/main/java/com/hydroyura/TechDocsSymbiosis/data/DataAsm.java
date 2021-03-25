package com.hydroyura.TechDocsSymbiosis.data;

public class DataAsm {

	private int id, asmId, count, change;
	
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "DataAsm [id=" + id + ", asmId=" + asmId + ", count=" + count + ", change=" + change + ", number="
				+ number + "]";
	}

	public int getAsmId() {
		return asmId;
	}

	public void setAsmId(int asmId) {
		this.asmId = asmId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

}
