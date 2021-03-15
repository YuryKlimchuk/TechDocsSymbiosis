package com.hydroyura.TechDocsSymbiosis.buy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.itemmappers.BuyItemMap;
import com.hydroyura.TechDocsSymbiosis.basicclasses.rowmappers.BuyRowMap;

@Component("BuyService")
@Service
public class BuyService extends ServiceBasic<BuyEntity> {

	@PostConstruct
	public void init() {
		TABLE_NAME = Constants.TABLE_NAME_BUY;
		rowMapper = new BuyRowMap();
		itemMapper = new BuyItemMap();
	}
	
}
