package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.init.Constants;
import com.hydroyura.TechDocsSymbiosis.opp.OppRowMap;

@Component
public class AsmDao {

	private JdbcTemplate jdbc;

	@Autowired
	public AsmDao(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	
	public List<Asm> getAsmList() {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ASM + ";";
		return jdbc.query(query, new AsmRowMap());
	}
	
	
	
	public void addOppInAsm(int asm_full_id, int opp_id, int opp_counts, int opp_change) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM_COMP_OPP + "(" 
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_ASM_FULL_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_OPP_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_COUNTS + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_OPP_CHANGE + ") VALUES (?, ?, ?, ?);";
		
		jdbc.update(query, asm_full_id, opp_id, opp_counts, opp_change);
	}
	
	
	public void addOringInAsm(int asm_full_id, int oring_id, int oring_counts, int oring_change) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM_COMP_ORING + "(" 
				+ Constants.TABLE_COLOMN_ASM_COMP_ORING_ASM_FULL_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_ORING_ORING_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_ORING_COUNTS + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_ORING_CHANGE + ") VALUES (?, ?, ?, ?);";
		
		jdbc.update(query, asm_full_id, oring_id, oring_counts, oring_change);
	}
	
	

	
	public Asm getAsmByNumber(String number) {
		String query = "SELECT * FROM " + Constants.TABLE_NAME_ASM + " WHERE " + Constants.TABLE_COLOMN_ASM_NUMBER + "='" + number + "';";
		return jdbc.queryForObject(query, new AsmRowMap());	
	}
	
	
	public int addAsm(Asm asm) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM + " (" 
				+ Constants.TABLE_COLOMN_ASM_NUMBER+ ", " 
				+ Constants.TABLE_COLOMN_ASM_NAME + ", " 
				+ Constants.TABLE_COLOMN_ASM_STATUS + ", " 
				+ Constants.TABLE_COLOMN_ASM_VERSION + ", " 
				+ Constants.TABLE_COLOMN_ASM_UPDATE + ") VALUES (?, ?, ?, ?, ?);";
		return jdbc.update(query, asm.getNumber(), asm.getName(), asm.getStatus(), asm.getVersion(), asm.getUpdate());
	}
	
	public List<Asm> getAsmListByStatus(String status) {
		
		return null;
	}
	
	/*
	 * 
	 * 	public int addOpp(Opp opp) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_OPP + " (" 
				+ Constants.TABLE_COLOMN_OPP_NUMBER+ ", " 
				+ Constants.TABLE_COLOMN_OPP_NAME + ", " 
				+ Constants.TABLE_COLOMN_OPP_STATUS + ", " 
				+ Constants.TABLE_COLOMN_OPP_VERSION + ", " 
				+ Constants.TABLE_COLOMN_OPP_UPDATE + ") VALUES (?, ?, ?, ?, ?);";
		return jdbcTemplate.update(query, opp.getNumber(), opp.getName(), opp.getStatus(), opp.getVersion(), opp.getUpdate());
	}
	 * 
	 * 
	 */
	
}
