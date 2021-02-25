package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

// class describes form for entering information about assembly composition
public class AsmCompositionForm {
	
	private int countOpp, countOring;
	private Asm asm;

	private List<Integer> listOppId, listOppCounts;
	private List<Integer> listOringId, listOringCounts;
	
	
	




	public List<Integer> getListOppCounts() {
		return listOppCounts;
	}



	public List<Integer> getListOringId() {
		return listOringId;
	}



	public List<Integer> getListOringCounts() {
		return listOringCounts;
	}



	public void setListOppCounts(List<Integer> listOppCounts) {
		this.listOppCounts = listOppCounts;
	}



	public void setListOringId(List<Integer> listOringId) {
		this.listOringId = listOringId;
	}



	public void setListOringCounts(List<Integer> listOringCounts) {
		this.listOringCounts = listOringCounts;
	}



	public List<Integer> getListOppId() {
		return listOppId;
	}



	public void setListOppId(List<Integer> listOppId) {
		this.listOppId = listOppId;
	}



	

	public Asm getAsm() {
		return asm;
	}



	public void setAsm(Asm asm) {
		this.asm = asm;
	}



	public int getCountOpp() {
		return countOpp;
	}






	@Override
	public String toString() {
		return "AsmCompositionForm [countOpp=" + countOpp + ", countOring=" + countOring + ", asm=" + asm
				+ ", listOppId=" + listOppId + ", listOppCounts=" + listOppCounts + ", listOringId=" + listOringId
				+ ", listOringCounts=" + listOringCounts + "]";
	}



	public int getCountOring() {
		return countOring;
	}

	public void setCountOpp(int countOpp) {
		this.countOpp = countOpp;
	}

	public void setCountOring(int countOring) {
		this.countOring = countOring;
	}
	
	public int incCountOpp() {
		this.countOpp++;
		return this.countOpp;
	}
	
	public int incCountOring() {
		this.countOring++;
		return countOring;
	}
	
	public int decCountOpp() {
		if(this.countOpp != 0) {
			this.countOpp--;
			return this.countOpp;
		} 
		return this.countOpp;
	}
	
	public int decCountOring() {
		if(this.countOring != 0) {
			this.countOring--;
			return this.countOring;
		} 
		return this.countOring;
	}
	
	
	

}
