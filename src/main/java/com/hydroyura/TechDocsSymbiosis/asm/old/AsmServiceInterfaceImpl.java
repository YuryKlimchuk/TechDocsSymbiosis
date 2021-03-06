package com.hydroyura.TechDocsSymbiosis.asm.old;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.asm.Asm;


public class AsmServiceInterfaceImpl implements AsmServiceInterface {

	
	private AsmDao asmDao;
	
	

	@Autowired
	public AsmServiceInterfaceImpl(AsmDao asmDao) {
		this.asmDao = asmDao;
	}
	
	
	


	@Override
	public void addAsm(Asm asm) {
		asmDao.addAsm(asm);
	}


	@Override
	public boolean addAsmComposition(AsmCompositionForm asmCompositionForm) {
		
		asmDao.addAsm(asmCompositionForm.getAsm());
		
		int asm_id = asmDao.getAsmByNumber(asmCompositionForm.getAsm().getNumber()).getId();
		
		for(int i = 0; i < asmCompositionForm.getListOppId().size(); i++) {
			
			asmDao.addOppInAsm(
					asm_id,
					asmCompositionForm.getListOppId().get(i),
					asmCompositionForm.getListOppCounts().get(i),
					-1);
			
		}
		
		for(int i = 0; i < asmCompositionForm.getListOringId().size(); i++) {
			
			asmDao.addOringInAsm(
					asm_id,
					asmCompositionForm.getListOringId().get(i),
					asmCompositionForm.getListOringCounts().get(i),
					-1);
			
		}
		
		for(int i = 0; i < asmCompositionForm.getListVzkId().size(); i++) {
			
			asmDao.addVzkInAsm(
					asm_id,
					asmCompositionForm.getListVzkId().get(i),
					asmCompositionForm.getListVzkCounts().get(i),
					-1);
			
		}
		
		
		for(int i = 0; i < asmCompositionForm.getListBuyId().size(); i++) {
			
			asmDao.addBuyInAsm(
					asm_id,
					asmCompositionForm.getListBuyId().get(i),
					asmCompositionForm.getListBuyCounts().get(i),
					-1);
			
		}
		
		
		for(int i = 0; i < asmCompositionForm.getListAsmId().size(); i++) {
			
			asmDao.addAsmInAsm(
					asm_id,
					asmCompositionForm.getListAsmId().get(i),
					asmCompositionForm.getListAsmCounts().get(i),
					-1);
			
		}
		
		for(int i = 0; i < asmCompositionForm.getListStpId().size(); i++) {
			
			asmDao.addStpInAsm(
					asm_id,
					asmCompositionForm.getListStpId().get(i),
					asmCompositionForm.getListStpCounts().get(i),
					-1);
			
		}
		
		
		return true;
	}





	@Override
	public List<Asm> getAsmList() {
		return asmDao.getAsmList();
	}
	
	
	
	
	
	
	
	
	
}
