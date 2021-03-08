package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;

@Component("OringServiceImpl")
@Service
public class OringServiceImpl implements ServiceInterface<OringEntity> {
	
	@Autowired
	@Qualifier("OringDaoImpl")
	private DaoInterface<OringEntity> dao;

	@Override
	public List<OringEntity> getAll() {
		return dao.getAll();
	}

	@Override
	public OringEntity getItemById(int id) {
		return dao.getItemById(id);
	}

	@Override
	public List<OringEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		//return dao.getAll();
		return dao.getItemsBySearchFilter(searchFilter);
	}

	@Override
	public boolean addItem(OringEntity item) {
		return dao.addItem(item);
	}

	@Override
	public boolean deleteItemById(int id) {
		return dao.deleteItemById(id);
	}

	@Override
	public boolean changeItem(int id, OringEntity newItem) {
		return dao.changeItem(id, newItem);
	}
	
	public float getMinInnerDiamter() {
		List<OringEntity> list = getAll();
		
		//float min = list.get(0).getInnerDiameter();
		float min = 10000f;
		for (OringEntity oring : list) {
			if(oring.getInnerDiameter() < min) {
				min = oring.getInnerDiameter();
			}
		}
		return min;
	}
	
	public float getMaxInnerDiamter() {
		List<OringEntity> list = getAll();
		//float max = list.get(0).getInnerDiameter();
		float max = -10000f;
		for (OringEntity oring : list) {
			if(oring.getInnerDiameter() > max) {
				max = oring.getInnerDiameter();
			}
		}
		return max;
	}

	@Override
	public List<Float> getFloatList() {
		return dao.getFloatList();
	}

	@Override
	public List<String> getStringList() {
		// TODO Auto-generated method stub
		return null;
	}



}
