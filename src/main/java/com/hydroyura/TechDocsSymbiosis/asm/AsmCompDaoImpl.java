package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.DaoInterface;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;
import com.hydroyura.TechDocsSymbiosis.init.Constants;


@Component("AsmCompDaoImpl")
@Repository
public class AsmCompDaoImpl implements DaoInterface<AsmComposition>{

	
	@Autowired
	@Qualifier("AsmDaoImpl")
	private AsmDaoImpl asmDao;

	@Autowired
	private JdbcTemplate jdbc;
	
	
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
		int asmID = asmDao.addItemWithIdReturn(item.getAsm());
		
		System.out.println("ADD and ID = " + asmID);
		String query;
		
		query = "INSERT INTO " + Constants.TABLE_NAME_ASM_COMP_OPP + " ("  
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_ASM_FULL_ID + ", "
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_OPP_ID + ", "
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_COUNTS + ", "
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_CHANGE + ") VALUES (?, ?, ?, ?);";
		
		for(int i = 0; i < item.getAsmOppId().size(); i++) {
			jdbc.update(query, 
					asmID,
					item.getAsmOppId().get(i),
					item.getAsmOppCount().get(i),
					-1);
		}
		
		
		query = "INSERT INTO " + Constants.TABLE_NAME_ASM_COMP_ORING + " ("  
				+ Constants.TABLE_COLOMN_ASM_COMP_ORING_ASM_FULL_ID + ", "
				+ Constants.TABLE_COLOMN_ASM_COMP_ORING_ORING_ID + ", "
				+ Constants.TABLE_COLOMN_ASM_COMP_ORING_COUNTS + ", "
				+ Constants.TABLE_COLOMN_ASM_COMP_ORING_CHANGE + ") VALUES (?, ?, ?, ?);";
		
		for(int i = 0; i < item.getAsmOringId().size(); i++) {
			jdbc.update(query, 
					asmID,
					item.getAsmOringId().get(i),
					item.getAsmOringCount().get(i),
					-1);
		}
		
		
		
		return true;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItemDeleted(AsmComposition item) {
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

	@Override
	public int addItemWithIdReturn(AsmComposition item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getStringList() {
		// TODO Auto-generated method stub
		return null;
	}

}
