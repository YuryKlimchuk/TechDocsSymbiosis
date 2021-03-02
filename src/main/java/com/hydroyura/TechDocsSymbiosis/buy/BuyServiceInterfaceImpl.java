package com.hydroyura.TechDocsSymbiosis.buy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BuyServiceInterfaceImpl implements BuyServiceInterface {

	@Autowired
	private BuyDao buyDao;
	
	
	@Override
	public List<Buy> getAll() {
		return buyDao.getAll();
	}

}
