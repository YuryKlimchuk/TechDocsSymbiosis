package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OringServiceInterfaceImpl implements OringServiceInterface {
	
	private OringDao oringDao;

	@Autowired
	public OringServiceInterfaceImpl(OringDao oringDao) {

		this.oringDao = oringDao;
	}

	@Override
	public List<Oring> getOringList() {
		return oringDao.getOringList();
	}

	@Override
	public Oring getOringItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Float> getCrossSectionList() {
		return oringDao.getOringCrossSections();
	}

	@Override
	public List<Oring> getOringListByFilter(OringFilter oringFilter) {
		return oringDao.getOringListByCrossSectionAndInnerDiameter(oringFilter.getCrossSectionListSelected(), oringFilter.getMinInnerDiameter(), oringFilter.getMaxInnerDiameter());
	}

	@Override
	public float getMaxInnerDiameter() {
		return oringDao.getOringsMaxInternalDiameter();
	}

	@Override
	public float getMinInnerDiameter() {
		return oringDao.getOringsMinInternalDiameter();
	}

}
