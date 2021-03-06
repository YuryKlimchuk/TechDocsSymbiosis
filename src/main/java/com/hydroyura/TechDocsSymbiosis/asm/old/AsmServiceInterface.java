package com.hydroyura.TechDocsSymbiosis.asm.old;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.asm.Asm;


public interface AsmServiceInterface {
	
	
	public boolean addAsmComposition(AsmCompositionForm asmCompositionForm); 
	
	public List<Asm> getAsmList();
	
	
	public void addAsm(Asm asm);

}
