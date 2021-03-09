package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.ArrayList;
import java.util.List;



public class AsmComposition {
	
	private AsmEntity asm;
	
	private List<Integer> asmOppId = new ArrayList<>();
	private List<Integer> asmOppCount = new ArrayList<>();
	
	private List<Integer> asmOringId = new ArrayList<>();
	private List<Integer> asmOringCount = new ArrayList<>();
	
	private List<Integer> asmVzkId = new ArrayList<>();
	private List<Integer> asmVzkCount = new ArrayList<>();
	
	private List<Integer> asmAsmId = new ArrayList<>();
	private List<Integer> asmAsmCount = new ArrayList<>();
	
	private List<Integer> asmStpId = new ArrayList<>();
	private List<Integer> asmStpCount = new ArrayList<>();
	
	private List<Integer> asmBuyId = new ArrayList<>();
	private List<Integer> asmBuyCount = new ArrayList<>();
	
	public List<Integer> getAsmOringId() {
		return asmOringId;
	}

	public List<Integer> getAsmOringCount() {
		return asmOringCount;
	}

	public void setAsmOringId(List<Integer> asmOringId) {
		this.asmOringId = asmOringId;
	}

	public void setAsmOringCount(List<Integer> asmOringCount) {
		this.asmOringCount = asmOringCount;
	}

	
	public AsmComposition() {
		incOppCount();
		incOringCount();
		incVzkCount();
		incBuyCount();
		incStpCount();
		incAsmCount();
	}

	public boolean incOppCount() {
		asmOppId.add(null);
		asmOppCount.add(1);
		return true;
	}
	
	public boolean decOppCount() {
		asmOppId.remove(asmOppId.size()-1);
		asmOppCount.remove(asmOppCount.size()-1);
		return true;
	}
	
	public boolean incOringCount() {
		asmOringId.add(null);
		asmOringCount.add(1);
		return true;
	}
	
	public boolean decOringCount() {
		asmOringId.remove(asmOppId.size()-1);
		asmOringCount.remove(asmOppCount.size()-1);
		return true;
	}
	
	public boolean incVzkCount() {
		asmVzkId.add(null);
		asmVzkCount.add(1);
		return true;
	}
	
	public boolean decVzkCount() {
		asmVzkId.remove(asmVzkId.size()-1);
		asmVzkCount.remove(asmVzkCount.size()-1);
		return true;
	}
	
	public boolean incBuyCount() {
		asmBuyId.add(null);
		asmBuyCount.add(1);
		return true;
	}
	
	public boolean decBuyCount() {
		asmBuyId.remove(asmBuyId.size()-1);
		asmBuyCount.remove(asmBuyCount.size()-1);
		return true;
	}
	
	public boolean incAsmCount() {
		asmAsmId.add(null);
		asmAsmCount.add(1);
		return true;
	}
	
	public boolean decAsmCount() {
		asmAsmId.remove(asmAsmId.size()-1);
		asmAsmCount.remove(asmAsmCount.size()-1);
		return true;
	}
	
	public boolean incStpCount() {
		asmStpId.add(null);
		asmStpCount.add(1);
		return true;
	}
	
	public boolean decStpCount() {
		asmStpId.remove(asmStpId.size()-1);
		asmStpCount.remove(asmStpCount.size()-1);
		return true;
	}
	
	
	public AsmEntity getAsm() {
		return asm;
	}


	public void setAsm(AsmEntity asm) {
		this.asm = asm;
	}

	public List<Integer> getAsmOppId() {
		return asmOppId;
	}

	public List<Integer> getAsmOppCount() {
		return asmOppCount;
	}

	public void setAsmOppId(List<Integer> asmOppId) {
		this.asmOppId = asmOppId;
	}

	public void setAsmOppCount(List<Integer> asmOppCount) {
		this.asmOppCount = asmOppCount;
	}

	
	public List<Integer> getAsmVzkId() {
		return asmVzkId;
	}

	public void setAsmVzkId(List<Integer> asmVzkId) {
		this.asmVzkId = asmVzkId;
	}

	public List<Integer> getAsmVzkCount() {
		return asmVzkCount;
	}

	public void setAsmVzkCount(List<Integer> asmVzkCount) {
		this.asmVzkCount = asmVzkCount;
	}

	public List<Integer> getAsmAsmId() {
		return asmAsmId;
	}

	public void setAsmAsmId(List<Integer> asmAsmId) {
		this.asmAsmId = asmAsmId;
	}

	public List<Integer> getAsmAsmCount() {
		return asmAsmCount;
	}

	public void setAsmAsmCount(List<Integer> asmAsmCount) {
		this.asmAsmCount = asmAsmCount;
	}

	public List<Integer> getAsmStpId() {
		return asmStpId;
	}

	public void setAsmStpId(List<Integer> asmStpId) {
		this.asmStpId = asmStpId;
	}

	public List<Integer> getAsmStpCount() {
		return asmStpCount;
	}

	public void setAsmStpCount(List<Integer> asmStpCount) {
		this.asmStpCount = asmStpCount;
	}

	public List<Integer> getAsmBuyId() {
		return asmBuyId;
	}

	public void setAsmBuyId(List<Integer> asmBuyId) {
		this.asmBuyId = asmBuyId;
	}

	public List<Integer> getAsmBuyCount() {
		return asmBuyCount;
	}

	public void setAsmBuyCount(List<Integer> asmBuyCount) {
		this.asmBuyCount = asmBuyCount;
	}

	@Override
	public String toString() {
		return "AsmComposition [asm=" + asm + ", asmOppId=" + asmOppId + ", asmOppCount=" + asmOppCount
				+ ", asmOringId=" + asmOringId + ", asmOringCount=" + asmOringCount + ", asmVzkId=" + asmVzkId
				+ ", asmVzkCount=" + asmVzkCount + ", asmAsmId=" + asmAsmId + ", asmAsmCount=" + asmAsmCount
				+ ", asmStpId=" + asmStpId + ", asmStpCount=" + asmStpCount + ", asmBuyId=" + asmBuyId
				+ ", asmBuyCount=" + asmBuyCount + "]";
	}



	
	
	
}
