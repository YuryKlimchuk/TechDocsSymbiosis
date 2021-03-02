package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.hydroyura.TechDocsSymbiosis.init.Constants;

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
	
	//-----------------------------------------------------------------------------------------------
	
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
	
	public void addVzkInAsm(int asm_full_id, int vzk_id, int vzk_counts, int vzk_change) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM_COMP_VZK + "(" 
				+ Constants.TABLE_COLOMN_ASM_COMP_VZK_ASM_FULL_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_VZK_VZK_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_VZK_COUNTS + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_VZK_CHANGE + ") VALUES (?, ?, ?, ?);";
		
		jdbc.update(query, asm_full_id, vzk_id, vzk_counts, vzk_change);
	}
	
	
	public void addBuyInAsm(int asm_full_id, int buy_id, int buy_counts, int buy_change) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM_COMP_BUY + "(" 
				+ Constants.TABLE_COLOMN_ASM_COMP_BUY_ASM_FULL_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_BUY_BUY_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_BUY_COUNTS + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_BUY_CHANGE + ") VALUES (?, ?, ?, ?);";
		
		jdbc.update(query, asm_full_id, buy_id, buy_counts, buy_change);
	}
	
	
	public void addAsmInAsm(int asm_full_id, int asm_id, int asm_counts, int asm_change) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM_COMP_ASM + "(" 
				+ Constants.TABLE_COLOMN_ASM_COMP_ASM_ASM_FULL_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_ASM_ASM_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_ASM_COUNTS + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_BUY_CHANGE + ") VALUES (?, ?, ?, ?);";
		
		jdbc.update(query, asm_full_id, asm_id, asm_counts, asm_change);
	}
	
	
	public void addStpInAsm(int asm_full_id, int stp_id, int stp_counts, int stp_change) {
		String query = "INSERT INTO " + Constants.TABLE_NAME_ASM_COMP_STP + "(" 
				+ Constants.TABLE_COLOMN_ASM_COMP_STP_ASM_FULL_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_STP_STP_ID + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_STP_COUNTS + ", " 
				+ Constants.TABLE_COLOMN_ASM_COMP_STP_CHANGE + ") VALUES (?, ?, ?, ?);";
		
		jdbc.update(query, asm_full_id, stp_id, stp_counts, stp_change);
	}
	
	
	
	//-----------------------------------------------------------------------------------------------

	
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
