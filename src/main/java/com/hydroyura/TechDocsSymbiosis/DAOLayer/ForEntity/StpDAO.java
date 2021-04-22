package com.hydroyura.TechDocsSymbiosis.DAOLayer.ForEntity;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers.MapperFactory;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers.ReverseMapperFactory;
import com.hydroyura.TechDocsSymbiosis.Entities.Stp;

@Component("StpDAO")
public class StpDAO extends BasicDAOForEntity<Stp> {
	
	@PostConstruct
	private void init() {
		TABLE_NAME = Constants.TABLE_NAME_STP;
		mapper = MapperFactory.generateRowMap(Constants.ROW_MAPPER_STP);
		revMapper = ReverseMapperFactory.generateRowMap(Constants.ROW_MAPPER_STP);
	}

}
