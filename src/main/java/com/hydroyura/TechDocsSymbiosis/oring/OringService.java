package com.hydroyura.TechDocsSymbiosis.oring;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.OringItemMap;
import com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers.OringRowMap;

@Component("OringService")
@Service
public class OringService extends ServiceBasic<OringEntity> {
	@PostConstruct
	public void init() {
		TABLE_NAME = Constants.TABLE_NAME_ORINGS;
		rowMapper = new OringRowMap();
		itemMapper = new OringItemMap();
	}
}
