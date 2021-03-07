package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;
import com.hydroyura.TechDocsSymbiosis.opp.OppServiceImpl;
import com.hydroyura.TechDocsSymbiosis.oring.OringEntity;
import com.hydroyura.TechDocsSymbiosis.oring.OringServiceImpl;

@Component("AsmCompServiceImpl")
@Service
public class AsmCompServiceImpl implements ServiceInterface<AsmComposition> {

	@Autowired
	@Qualifier("AsmCompDaoImpl")
	private DaoInterface<AsmComposition> dao;
	
	@Autowired
	@Qualifier("AsmDaoImpl")
	private DaoInterface<AsmEntity> asmDao;
	
	@Autowired
	@Qualifier("OppServiceImpl")
	private OppServiceImpl oppService;
	
	@Autowired
	@Qualifier("OringServiceImpl")
	private OringServiceImpl oringService;
	
	@Override
	public List<AsmComposition> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AsmComposition getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsmComposition> getItemsBySearchFilter(SearchFilter searchFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(AsmComposition item) {
		return dao.addItem(item);
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, AsmComposition newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Float> getFloatList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OppEntity> getAllOpp() {
		return oppService.getAll();
	}
	
	public List<OringEntity> getAllOring() {
		return oringService.getAll();
	}
	
	public List<AsmEntity> getAllAsm() {
		return asmDao.getAll();
	}

}
