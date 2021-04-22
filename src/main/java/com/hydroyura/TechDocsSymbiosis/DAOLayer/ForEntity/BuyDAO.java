package com.hydroyura.TechDocsSymbiosis.DAOLayer.ForEntity;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers.MapperFactory;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers.ReverseMapperFactory;
import com.hydroyura.TechDocsSymbiosis.Entities.Buy;

@Component("BuyDAO")
public class BuyDAO extends BasicDAOForEntity<Buy> {
	
	@PostConstruct
	private void init() {
		TABLE_NAME = Constants.TABLE_NAME_BUY;
		mapper = MapperFactory.generateRowMap(Constants.ROW_MAPPER_BUY);
		revMapper = ReverseMapperFactory.generateRowMap(Constants.ROW_MAPPER_BUY);
	}

}
