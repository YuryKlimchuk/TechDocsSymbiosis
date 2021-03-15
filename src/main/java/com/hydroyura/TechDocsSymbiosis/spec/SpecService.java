package com.hydroyura.TechDocsSymbiosis.spec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.asm.AsmService;
import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.DaoBasic;
import com.hydroyura.TechDocsSymbiosis.data.DataAsm;
import com.hydroyura.TechDocsSymbiosis.data.DataService;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;
import com.hydroyura.TechDocsSymbiosis.opp.OppService;
import com.hydroyura.TechDocsSymbiosis.oring.OringEntity;
import com.hydroyura.TechDocsSymbiosis.oring.OringService;

@Component("SpecService")
public class SpecService {
	
	@Autowired
	@Qualifier("DaoBasic")
	private DaoBasic dao;
	
	@Autowired
	@Qualifier("AsmService")
	private AsmService asmService;
	
	@Autowired
	@Qualifier("OppService")
	private OppService oppService;
	
	@Autowired
	@Qualifier("OringService")
	private OringService oringService;
	
	@Autowired
	@Qualifier("DataService")
	private DataService dataService;
	
	
	public SpecEntity getSpecInfo(long id) {

		SpecEntity spec = new SpecEntity();
		spec.setAsm(asmService.getItem(id));
		
		List<DataAsm> opps = dataService.getItemsByLongCriteria(Constants.TABLE_NAME_ASM_COMP_OPP, id, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID);
		Map<String, Integer> oppsMap = new HashMap<String, Integer>();
		
		for (DataAsm dataAsm : opps) {
			OppEntity opp = oppService.getItem(dataAsm.getId()); 
			String str = opp.getNumber() + " " + opp.getName();
			oppsMap.put(str, dataAsm.getCount());
		}
		spec.setOpps(opps);
		spec.setOppsMap(oppsMap);
		
		
		List<DataAsm> orings = dataService.getItemsByLongCriteria(Constants.TABLE_NAME_ASM_COMP_ORING, id, Constants.TABLE_COLOMN_COMPOSITION_ASM_ID);
		Map<String, Integer> oringsMap = new HashMap<String, Integer>();
		
		for (DataAsm dataAsm : orings) {
			OringEntity oring = oringService.getItem(dataAsm.getId()); 
			String str = oring.getNumber() + " " + oring.getName();
			oringsMap.put(str, dataAsm.getCount());
		}
		spec.setOrings(orings);
		spec.setOringsMap(oringsMap);
		
		return spec;
	}

}
