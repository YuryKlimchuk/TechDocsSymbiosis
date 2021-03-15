package com.hydroyura.TechDocsSymbiosis.vzk;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.VzkItemMap;
import com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers.VzkRowMap;

@Component("VzkService")
@Service
public class VzkService extends ServiceBasic<VzkEntity> {
	@PostConstruct
	public void init() {
		TABLE_NAME = Constants.TABLE_NAME_VZK;
		rowMapper = new VzkRowMap();
		itemMapper = new VzkItemMap();
	}
}
