package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AsmServiceInterface {
	
	
	public boolean addAsmComposition(AsmCompositionForm asmCompositionForm); 
	
	public List<Asm> getAsmList();
	
	
	public void addAsm(Asm asm);

}
