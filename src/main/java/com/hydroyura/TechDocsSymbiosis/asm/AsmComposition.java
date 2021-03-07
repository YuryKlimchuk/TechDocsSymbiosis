package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.ArrayList;
import java.util.List;



public class AsmComposition {
	
	private AsmEntity asm;
	
	private List<Integer> asmOppId = new ArrayList<>();
	private List<Integer> asmOppCount = new ArrayList<>();
	
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

	private List<Integer> asmOringId = new ArrayList<>();
	private List<Integer> asmOringCount = new ArrayList<>();
	
	public AsmComposition() {
		incOppCount();
		incOringCount();
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

	@Override
	public String toString() {
		return "AsmComposition [asm=" + asm + ", asmOppId=" + asmOppId + ", asmOppCount=" + asmOppCount + "]";
	}

	
	
	
}
