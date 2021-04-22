package com.hydroyura.TechDocsSymbiosis.DAOLayer.ForEntity;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.Mappers.MapperFactory;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ReversMappers.ReverseMapperFactory;
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;

@Component("AsmDAO")
public class AsmDAO extends BasicDAOForEntity<Asm> {
	
	
	@PostConstruct
	private void init() {
		TABLE_NAME = Constants.TABLE_NAME_ASM;
		mapper = MapperFactory.generateRowMap(Constants.ROW_MAPPER_ASM);
		revMapper = ReverseMapperFactory.generateRowMap(Constants.ROW_MAPPER_ASM);
	}

}
