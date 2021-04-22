package com.hydroyura.TechDocsSymbiosis.DAOLayer.ForEntity;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers.MapperFactory;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers.ReverseMapperFactory;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;

@Component("VzkDAO")
public class VzkDAO extends BasicDAOForEntity<Vzk> {
	
	@PostConstruct
	private void init() {
		TABLE_NAME = Constants.TABLE_NAME_VZK;
		mapper = MapperFactory.generateRowMap(Constants.ROW_MAPPER_VZK);
		revMapper = ReverseMapperFactory.generateRowMap(Constants.ROW_MAPPER_VZK);
	}

}
