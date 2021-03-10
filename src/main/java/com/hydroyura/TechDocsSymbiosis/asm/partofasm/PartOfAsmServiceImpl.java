package com.hydroyura.TechDocsSymbiosis.asm.partofasm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;

@Component("PartOfAsmServiceImpl")
@Service
public class PartOfAsmServiceImpl implements ServiceInterface<PartOfAsmEntity> {

	@Autowired
	@Qualifier("PartOfAsmDaoImpl")
	private DaoInterface<PartOfAsmEntity> dao;
	
	@Override
	public List<PartOfAsmEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartOfAsmEntity getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartOfAsmEntity> getItemsBySearchFilter(SearchFilter searchFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(PartOfAsmEntity item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeItem(int id, PartOfAsmEntity newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Float> getFloatList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getStringList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PartOfAsmEntity> getAllFromTableByIntCreteria(String tableName, int creteria) {
		return dao.getAllFromTableByCreteria(tableName, creteria);
	}


}
