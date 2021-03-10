package com.hydroyura.TechDocsSymbiosis.asm.partofasm;

public class PartOfAsmEntity {
	
	// entity field
	private int id, asmId, count, change;
	
	public PartOfAsmEntity() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "PartOfAsmEntity [id=" + id + ", asmId=" + asmId + ", count=" + count + ", change=" + change + "]";
	}
	
	

}
