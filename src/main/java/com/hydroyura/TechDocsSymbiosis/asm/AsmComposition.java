package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.ArrayList;
import java.util.List;



public class AsmComposition {
	
	private AsmEntity asm;
	
	private List<Integer> asmOppId = new ArrayList<>();
	private List<Integer> asmOppCount = new ArrayList<>();
	
	public AsmComposition() {
		incOppCount();
	}

	public boolean incOppCount() {
		asmOppId.add(null);
		asmOppCount.add(Integer.valueOf(1));
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
