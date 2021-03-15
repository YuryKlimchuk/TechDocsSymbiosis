package com.hydroyura.TechDocsSymbiosis.opp;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.OppItemMap;
import com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers.OppRowMap;


@Component("OppService")
@Service
public class OppService extends ServiceBasic<OppEntity> {

	@PostConstruct
	public void init() {
		TABLE_NAME = Constants.TABLE_NAME_OPP;
		rowMapper = new OppRowMap();
		itemMapper = new OppItemMap();
	}
	
}
