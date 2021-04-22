package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ForSpecRow.CompositeKeySpecRow;
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;
import com.hydroyura.TechDocsSymbiosis.Entities.SpecificationRow;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.SpecRowCompareByEntityIdAndType;

public class BasicServiceForEntity<T> implements BasicServiceInterface<T, Long> {
	
	protected BasicDAOInterface<T, Long> entityDAO;
	
	protected String ENTITY_TYPE;
	
	@Autowired
	@Qualifier("AsmDAO")
	protected BasicDAOInterface<Asm, Long> asmDAO;
	
	@Autowired
	@Qualifier("SpecRowDAO")
	protected BasicDAOInterface<SpecificationRow, CompositeKeySpecRow> specRowDAO;
	
	
	public BasicServiceForEntity(BasicDAOInterface<T, Long> entityDAO, String ENTITY_TYPE) {
		this.entityDAO = entityDAO;
		this.ENTITY_TYPE = ENTITY_TYPE;
	}

	@Override
	public List<T> getFilteredEntities(Filter<T> filter) {
		List<T> allEntities = entityDAO.getAllEntities();
		List<T> sortEntities = new ArrayList<T>();
		
		if(filter != null) {
			for (T entity : allEntities) {
				if(filter.compare(entity)) {
					sortEntities.add(entity);
				}
			}
		} else {
			return allEntities;
		}
		
		allEntities.clear();
		
		return sortEntities;
	}

	@Override
	public T getEntity(Long id) {
		return entityDAO.getEntity(id);
	}

	@Override
	public Map<Asm, Long> getSpecificationRowsByEntityId(long entityId) {
		List<SpecificationRow> unsortedSpecRows = specRowDAO.getAllEntities();
		List<SpecificationRow> sortedSpecRows = new ArrayList<SpecificationRow>();
		Filter<SpecificationRow> filter = new SpecRowCompareByEntityIdAndType(ENTITY_TYPE, entityId);
		for (SpecificationRow specRow : unsortedSpecRows)
			if(filter.compare(specRow))
				sortedSpecRows.add(specRow);
		Map<Asm, Long> resultMap = new HashMap<Asm, Long>();
		for (SpecificationRow specRow : sortedSpecRows) {
			resultMap.put(asmDAO.getEntity(specRow.getAsmId()), specRow.getCount());
		}
		return resultMap;
	}

	@Override
	public Long getSpecificationRowsByEntityId(T entity) {
		return entityDAO.addEntity(entity);
	}

	@Override
	public long addEntity(T entity) {
		return entityDAO.addEntity(entity);
	}

	@Override
	public long deleteEntity(Long id) {
		return entityDAO.delete(id);
	}

	@Override
	public long update(Long id, T newEntity) {
		return entityDAO.update(id, newEntity);
	}
	
	
	

}
