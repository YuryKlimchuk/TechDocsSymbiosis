package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

// class describes form for entering information about assembly composition
public class AsmCompositionForm {
	
	// Количество строчек в форме
	private int countOpp, countOring, countStp, countVzk, countBuy, countAsm;
	public int getCountVzk() {
		return countVzk;
	}

	public void setCountVzk(int countVzk) {
		this.countVzk = countVzk;
	}

	private Asm asm;
	private List<Integer> listOppId, listOppCounts, listStpCounts, listOringId, listOringCounts, listStpId, listVzkId, listVzkCounts, listBuyId, listBuyCounts, listAsmId, listAsmCounts;
	
	
	public List<Integer> getListAsmId() {
		return listAsmId;
	}

	public void setListAsmId(List<Integer> listAsmId) {
		this.listAsmId = listAsmId;
	}

	public List<Integer> getListAsmCounts() {
		return listAsmCounts;
	}

	public void setListAsmCounts(List<Integer> listAsmCounts) {
		this.listAsmCounts = listAsmCounts;
	}

	public int getCountBuy() {
		return countBuy;
	}

	public void setCountBuy(int countBuy) {
		this.countBuy = countBuy;
	}

	public int getCountAsm() {
		return countAsm;
	}

	public void setCountAsm(int countAsm) {
		this.countAsm = countAsm;
	}

	public List<Integer> getListBuyId() {
		return listBuyId;
	}

	public void setListBuyId(List<Integer> listBuyId) {
		this.listBuyId = listBuyId;
	}

	public List<Integer> getListBuyCounts() {
		return listBuyCounts;
	}

	public void setListBuyCounts(List<Integer> listBuyCounts) {
		this.listBuyCounts = listBuyCounts;
	}

	public List<Integer> getListVzkId() {
		return listVzkId;
	}

	public AsmCompositionForm() {
		System.out.println("CREATE ASM_COMP");
	}


	public void setListVzkId(List<Integer> listVzkId) {
		this.listVzkId = listVzkId;
	}



	public List<Integer> getListVzkCounts() {
		return listVzkCounts;
	}



	public void setListVzkCounts(List<Integer> listVzkCounts) {
		this.listVzkCounts = listVzkCounts;
	}



	public int getCountStp() {
		return countStp;
	}



	public List<Integer> getListStpCounts() {
		return listStpCounts;
	}



	public List<Integer> getListStpId() {
		return listStpId;
	}



	public void setCountStp(int countStp) {
		this.countStp = countStp;
	}



	public void setListStpCounts(List<Integer> listStpCounts) {
		this.listStpCounts = listStpCounts;
	}



	public void setListStpId(List<Integer> listStpId) {
		this.listStpId = listStpId;
	}



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
		return "AsmCompositionForm [countOpp=" + countOpp + ", countOring=" + countOring + ", countStp=" + countStp
				+ ", countVzk=" + countVzk + ", asm=" + asm + ", listOppId=" + listOppId + ", listOppCounts="
				+ listOppCounts + ", listStpCounts=" + listStpCounts + ", listOringId=" + listOringId
				+ ", listOringCounts=" + listOringCounts + ", listStpId=" + listStpId + ", listVzkId=" + listVzkId
				+ ", listVzkCounts=" + listVzkCounts + "]";
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
	
	
	
	
	//--------------------------------
	public int incCountOpp() {
		this.countOpp++;
		return this.countOpp;
	}
	
	public int incCountOring() {
		this.countOring++;
		return countOring;
	}
	
	public int incCountStp() {
		this.countStp++;
		return countStp;
	}
	
	public int incCountVzk() {
		this.countVzk++;
		return countVzk;
	}
	
	public int incCountBuy() {
		this.countBuy++;
		return countBuy;
	}
	
	public int incCountAsm() {
		this.countAsm++;
		return countAsm;
	}
	
	
	// ----------------------------------------
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
	
	public int decCountStp() {
		if(this.countStp != 0) {
			this.countStp--;
			return this.countStp;
		} 
		return this.countStp;
	}
	
	public int decCountVzk() {
		if(this.countVzk != 0) {
			this.countVzk--;
			return this.countVzk;
		} 
		return this.countVzk;
	}
	
	public int decCountBuy() {
		if(this.countBuy != 0) {
			this.countBuy--;
			return this.countBuy;
		} 
		return this.countBuy;
	}
	
	public int decCountAsm() {
		if(this.countAsm != 0) {
			this.countAsm--;
			return this.countAsm;
		} 
		return this.countAsm;
	}
	
	

}
