package com.hydroyura.TechDocsSymbiosis.stp;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.StpItemMap;
import com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers.StpRowMap;

@Component("StpService")
@Service
public class StpService extends ServiceBasic<StpEntity> {
	@PostConstruct
	public void init() {
		TABLE_NAME = Constants.TABLE_NAME_STP;
		rowMapper = new StpRowMap();
		itemMapper = new StpItemMap();
	}
}
