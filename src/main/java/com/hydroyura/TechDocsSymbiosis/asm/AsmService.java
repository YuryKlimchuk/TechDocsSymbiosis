package com.hydroyura.TechDocsSymbiosis.asm;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.AsmItemMap;
import com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers.AsmRowMap;


@Component("AsmService")
@Service
public class AsmService extends ServiceBasic<AsmEntity> {

	@PostConstruct
	public void init() {
		TABLE_NAME = Constants.TABLE_NAME_ASM;
		rowMapper = new AsmRowMap();
		itemMapper = new AsmItemMap();
	}
	

	
}
