package com.hydroyura.TechDocsSymbiosis.data;

import java.util.ArrayList;
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
	
	
	/*
	public Map<DataAsm, AsmEntity> getOppInAsm(int CRITERIA_VALUE) {
		
		// список для хранения вхождений в сборки детали
		List<DataAsm> oppData = getItemsByintCriteria(Constants.TABLE_NAME_ASM_COMP_OPP, CRITERIA_VALUE, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID);
		Map<DataAsm, AsmEntity> oppInAsmMap = new HashMap<DataAsm, AsmEntity>();
		
		for (DataAsm dataAsm : oppData) {
			oppInAsmMap.put(dataAsm, asmService.getItem(dataAsm.getAsmId()));
		}
		
		return oppInAsmMap;
	}
	
	
	public Map<DataAsm, AsmEntity> getOringInAsm(int CRITERIA_VALUE) {
		
		// список для хранения вхождений в сборки детали
		List<DataAsm> oringData = getItemsByIntCriteria(Constants.TABLE_NAME_ASM_COMP_ORING, CRITERIA_VALUE, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID);
		Map<DataAsm, AsmEntity> oringInAsmMap = new HashMap<DataAsm, AsmEntity>();
		
		for (DataAsm dataAsm : oringData) {
			oringInAsmMap.put(dataAsm, asmService.getItem(dataAsm.getAsmId()));
		}
		
		return oringInAsmMap;
	}
	*/
	
	
	public List<DataAsm> getOppsInAsm(int asmid) {
		
		List<DataAsm> list = new ArrayList<DataAsm>();
		
		List<DataAsm> list2 = dao.getItemsInnerJoinByintCriteria(
				Constants.TABLE_NAME_ASM_COMP_OPP, Constants.TABLE_NAME_OPP, 
				Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_OPP_ID, 
				Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, asmid, 
				new DataAsmRowMap());
		
		if(list2 != null) {
			list.addAll(list2);
		}
		
		return list2;
	}
	
	
	public List<DataAsm> getOringInAsm(int asmid) {
		
		List<DataAsm> list = new ArrayList<DataAsm>();
		
		List<DataAsm> list2 = dao.getItemsInnerJoinByintCriteria(
				Constants.TABLE_NAME_ASM_COMP_ORING, Constants.TABLE_NAME_ORINGS, 
				Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_ORINGS_ID, 
				Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, asmid, 
				new DataAsmRowMap());
		
		if(list2 != null) {
			list.addAll(list2);
		}
		
		return list2;
	}
	
	public List<DataAsm> getVzkInAsm(int asmid) {
		
		List<DataAsm> list = new ArrayList<DataAsm>();
		
		List<DataAsm> list2 = dao.getItemsInnerJoinByintCriteria(
				Constants.TABLE_NAME_ASM_COMP_VZK, Constants.TABLE_NAME_VZK, 
				Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_VZK_ID, 
				Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, asmid, 
				new DataAsmRowMap());
		
		if(list2 != null) {
			list.addAll(list2);
		}
		
		return list2;
	}
	
	public List<DataAsm> getStpInAsm(int asmid) {
		
		List<DataAsm> list = new ArrayList<DataAsm>();
		
		List<DataAsm> list2 = dao.getItemsInnerJoinByintCriteria(
				Constants.TABLE_NAME_ASM_COMP_STP, Constants.TABLE_NAME_STP, 
				Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_STP_ID, 
				Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, asmid, 
				new DataAsmRowMap());
		
		if(list2 != null) {
			list.addAll(list2);
		}
		
		return list2;
	}
	
	
	public List<DataAsm> getBuyInAsm(int asmid) {
		
		List<DataAsm> list = new ArrayList<DataAsm>();
		
		List<DataAsm> list2 = dao.getItemsInnerJoinByintCriteria(
				Constants.TABLE_NAME_ASM_COMP_BUY, Constants.TABLE_NAME_BUY, 
				Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_BUY_ID, 
				Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, asmid, 
				new DataAsmRowMap());
		
		if(list2 != null) {
			list.addAll(list2);
		}
		
		return list2;
	}
	
	public List<DataAsm> getAsmInAsm(int asmid) {
		
		List<DataAsm> list = new ArrayList<DataAsm>();
		
		List<DataAsm> list2 = dao.getItemsInnerJoinByintCriteria(
				Constants.TABLE_NAME_ASM_COMP_ASM, Constants.TABLE_NAME_ASM, 
				Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_ASM_ID, 
				Constants.TABLE_COLOMN_COMPOSITION_ASM_ID, asmid, 
				new DataAsmRowMap());
		
		if(list2 != null) {
			list.addAll(list2);
		}
		
		return list2;
	}
	
	
	public int deleteItemByDoubleKey(String _TABLE_NAME, int key1, int key2) {
		return this.deleteItemByDoubleKey(_TABLE_NAME, key1, key2, Constants.TABLE_COLOMN_COMPOSITION_ENTITY_ID, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID);
	}
	
	
	
	public int addItem(DataAsm dataAsm, String _TABLE_NAME) {
		Map<String, String> map = itemMapper.getValues(dataAsm);
		System.out.println("1");
		return dao.addItem(_TABLE_NAME, map);
	}

		
	

}
