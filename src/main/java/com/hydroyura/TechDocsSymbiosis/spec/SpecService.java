package com.hydroyura.TechDocsSymbiosis.spec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.asm.AsmEntity;
import com.hydroyura.TechDocsSymbiosis.asm.AsmService;
import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.DaoBasic;
import com.hydroyura.TechDocsSymbiosis.buy.BuyEntity;
import com.hydroyura.TechDocsSymbiosis.buy.BuyService;
import com.hydroyura.TechDocsSymbiosis.data.DataAsm;
import com.hydroyura.TechDocsSymbiosis.data.DataService;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;
import com.hydroyura.TechDocsSymbiosis.opp.OppService;
import com.hydroyura.TechDocsSymbiosis.oring.OringEntity;
import com.hydroyura.TechDocsSymbiosis.oring.OringService;
import com.hydroyura.TechDocsSymbiosis.stp.StpEntity;
import com.hydroyura.TechDocsSymbiosis.stp.StpService;
import com.hydroyura.TechDocsSymbiosis.vzk.VzkEntity;
import com.hydroyura.TechDocsSymbiosis.vzk.VzkService;

@Component("SpecService")
public class SpecService {
	
	@Autowired
	@Qualifier("DaoBasic")
	private DaoBasic dao;
	
	@Autowired
	@Qualifier("AsmService")
	private AsmService asmService;
	
	@Autowired
	@Qualifier("BuyService")
	private BuyService buyService;
	
	@Autowired
	@Qualifier("OppService")
	private OppService oppService;
	
	@Autowired
	@Qualifier("OringService")
	private OringService oringService;
	
	@Autowired
	@Qualifier("VzkService")
	private VzkService vzkService;
	
	@Autowired
	@Qualifier("DataService")
	private DataService dataService;
	
	@Autowired
	@Qualifier("StpService")
	private StpService stpService;
	
	
	public SpecEntity getSpecInfo(Integer id) {
		
		SpecEntity spec = new SpecEntity();
		spec.setAsm(asmService.getItem(id));
		//------------------------------------------------
		List<DataAsm> opps = new ArrayList<DataAsm>();
 		opps.addAll(dataService.getItemsByIntCriteria(Constants.TABLE_NAME_ASM_COMP_OPP, id, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID));
		Map<String,Integer> oppsMap = new HashMap<String, Integer>();
		
		for (DataAsm dataAsm : opps) {
			OppEntity opp = oppService.getItem(dataAsm.getId()); 
			String str = opp.getNumber() + " " + opp.getName();
			oppsMap.put(str, dataAsm.getCount());
		}
		spec.setOpps(opps);
		spec.setOppsMap(oppsMap);
	
		//------------------------------------------------
		List<DataAsm> orings = new ArrayList<DataAsm>();
		orings.addAll(dataService.getItemsByIntCriteria(Constants.TABLE_NAME_ASM_COMP_ORING, id, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID));
		Map<String, Integer> oringsMap = new HashMap<String, Integer>();
		
		for (DataAsm dataAsm : orings) {
			OringEntity oring = oringService.getItem(dataAsm.getId()); 
			String str = oring.getName() + " " + oring.getNumber() + " " + oring.getStandart();
			oringsMap.put(str, dataAsm.getCount());
		}
		spec.setOrings(orings);
		spec.setOringsMap(oringsMap);
		
		//------------------------------------------------
		List<DataAsm> vzks = new ArrayList<DataAsm>();
		vzks.addAll(dataService.getItemsByIntCriteria(Constants.TABLE_NAME_ASM_COMP_VZK, id, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID));
		Map<String, Integer> vzksMap = new HashMap<String, Integer>();
		
		for (DataAsm dataAsm : vzks) {
			VzkEntity vzk = vzkService.getItem(dataAsm.getId()); 
			String str = vzk.getNumber() + " " + vzk.getName();
			vzksMap.put(str, dataAsm.getCount());
		}
		spec.setVzks(vzks);
		spec.setVzksMap(vzksMap);
		
		
		//------------------------------------------------
		List<DataAsm> stps = new ArrayList<DataAsm>();
		stps.addAll(dataService.getItemsByIntCriteria(Constants.TABLE_NAME_ASM_COMP_STP, id, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID));
		Map<String, Integer> stpsMap = new HashMap<String, Integer>();
		
		for (DataAsm dataAsm : stps) {
			StpEntity stp = stpService.getItem(dataAsm.getId()); 
			String str = stp.getName() + " " + stp.getNumber() + " " + stp.getStandart();
			stpsMap.put(str, dataAsm.getCount());
		}
		spec.setStps(stps);
		spec.setStpsMap(stpsMap);
		
		//------------------------------------------------
		List<DataAsm> buys = new ArrayList<DataAsm>();
		buys.addAll(dataService.getItemsByIntCriteria(Constants.TABLE_NAME_ASM_COMP_BUY, id, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID));
		Map<String, Integer> buysMap = new HashMap<String, Integer>();
		
		for (DataAsm dataAsm : buys) {
			BuyEntity buy = buyService.getItem(dataAsm.getId()); 
			String str = buy.getNumber() + " " + buy.getName();
			buysMap.put(str, dataAsm.getCount());
		}
		spec.setBuys(buys);
		spec.setBuysMap(buysMap);
		
		//------------------------------------------------
		List<DataAsm> amss = new ArrayList<DataAsm>();
		amss.addAll(dataService.getItemsByIntCriteria(Constants.TABLE_NAME_ASM_COMP_ASM, id, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID));
		Map<String, Integer> amssMap = new HashMap<String, Integer>();
		
		for (DataAsm dataAsm : amss) {
			AsmEntity ams = asmService.getItem(dataAsm.getId()); 
			String str = ams.getNumber() + " " + ams.getName();
			amssMap.put(str, dataAsm.getCount());
		}
		spec.setAsms(amss);
		spec.setAsmsMap(amssMap);
		
		return spec;
	}
	
	

	public void getDetailedPartList(SpecEntity spec, Map<String, Integer> detailedList) {
		
		addIntoMap(spec.getBuysMap(), detailedList);
		addIntoMap(spec.getOppsMap(), detailedList);
		addIntoMap(spec.getOringsMap(), detailedList);
		addIntoMap(spec.getStpsMap(), detailedList);
		addIntoMap(spec.getVzksMap(), detailedList);
		
		if(spec.getAsms().size() == 0) {
			return;
		} else {
			
			for (int i = 0; i < spec.getAsms().size(); i++) {
				for (int j = 0; j < spec.getAsms().get(i).getCount(); j++) {
					Integer ID = spec.getAsms().get(i).getId();
					SpecEntity spec_new = getSpecInfo(ID);
					getDetailedPartList(spec_new, detailedList);
				}
			}
		}
	}

	
	private Map<String, Integer> addIntoMap(Map<String, Integer> elementsToAdd, Map<String, Integer> rootMap) {
		
		for (Map.Entry<String, Integer> entry : elementsToAdd.entrySet()) {
		    String key = entry.getKey();
		    Integer count = entry.getValue();
		    
		    if(rootMap.containsKey(key)) {
		    	rootMap.put(key, Integer.valueOf(rootMap.get(key) + count));
		    } else {
		    	rootMap.put(key, Integer.valueOf(count));
		    }
		    
		}
		return rootMap;	
	}
}
