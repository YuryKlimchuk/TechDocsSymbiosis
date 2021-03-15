package com.hydroyura.TechDocsSymbiosis.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.asm.AsmEntity;
import com.hydroyura.TechDocsSymbiosis.asm.AsmService;
import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.DataAsmItemMap;
import com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers.DataAsmRowMap;

@Component("DataService")
@Service
public class DataService extends ServiceBasic<DataAsm>{
	
	
	@PostConstruct
	public void init() {
		rowMapper = new DataAsmRowMap();
		itemMapper = new DataAsmItemMap();
	}
	
	@Autowired
	@Qualifier("AsmService")
	private AsmService asmService;
	
	
	public Map<DataAsm, AsmEntity> getOppInAsm(long CRITERIA_VALUE) {
		
		// список для хранения вхождений в сборки детали
		List<DataAsm> oppData = getItemsByLongCriteria(Constants.TABLE_NAME_ASM_COMP_OPP, CRITERIA_VALUE, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID);
		Map<DataAsm, AsmEntity> oppInAsmMap = new HashMap<DataAsm, AsmEntity>();
		
		for (DataAsm dataAsm : oppData) {
			oppInAsmMap.put(dataAsm, asmService.getItem(dataAsm.getAsmId()));
		}
		
		return oppInAsmMap;
	}
	
	
	public Map<DataAsm, AsmEntity> getOringInAsm(long CRITERIA_VALUE) {
		
		// список для хранения вхождений в сборки детали
		List<DataAsm> oringData = getItemsByLongCriteria(Constants.TABLE_NAME_ASM_COMP_ORING, CRITERIA_VALUE, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID);
		Map<DataAsm, AsmEntity> oringInAsmMap = new HashMap<DataAsm, AsmEntity>();
		
		for (DataAsm dataAsm : oringData) {
			oringInAsmMap.put(dataAsm, asmService.getItem(dataAsm.getAsmId()));
		}
		
		return oringInAsmMap;
	}

	
	

}
