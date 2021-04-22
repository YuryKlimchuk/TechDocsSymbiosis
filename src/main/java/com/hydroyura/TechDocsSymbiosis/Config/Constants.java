package com.hydroyura.TechDocsSymbiosis.Config;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Constants {
	
	// Имена таблиц
	public static final String TABLE_NAME_ORINGS 						= "orings";
	public static final String TABLE_NAME_ORINGS_DELETED 				= "orings_deleted";
	public static final String TABLE_NAME_STANDART_PARTS 				= "standart_parts";
	public static final String TABLE_NAME_NUMBER_PREFIXES 				= "number_prefixes";
	public static final String TABLE_NAME_OPP 							= "our_product_parts";
	public static final String TABLE_NAME_OPP_DELETED 					= "our_product_parts_deleted";
	public static final String TABLE_NAME_ASM 							= "assemblies";
	
	
	public static final String TABLE_NAME_ASM_COMP_OPP 					= "assembly_composition_opp";
	public static final String TABLE_NAME_ASM_COMP_ORING 				= "assembly_composition_oring";
	public static final String TABLE_NAME_ASM_COMP_VZK					= "assembly_composition_vzk";
	public static final String TABLE_NAME_ASM_COMP_BUY					= "assembly_composition_buy";
	public static final String TABLE_NAME_ASM_COMP_ASM					= "assembly_composition_asm";
	public static final String TABLE_NAME_ASM_COMP_STP					= "assembly_composition_stp";

	
	public static final String TABLE_NAME_STP 							= "standart_parts";
	public static final String TABLE_NAME_VZK 							= "vzk";
	public static final String TABLE_NAME_BUY  							= "buy";
	
	public static final String TABLE_NAME_PRODUCT  						="product";
	public static final String TABLE_NAME_SPECIFICATION_ROWS  			="specification_rows";
	//-------------------------------------------------------------------------------------
	
	// Название столбцов таблицы vzk
	public static final String TABLE_COLOMN_VZK_ID						= "id";
	public static final String TABLE_COLOMN_VZK_NUMBER					= "number";
	public static final String TABLE_COLOMN_VZK_NAME 					= "name";
	//-------------------------------------------------------------------------------------

	// Название столбцов таблицы buy
	public static final String TABLE_COLOMN_BUY_ID 						= "id";
	public static final String TABLE_COLOMN_BUY_NUMBER 					= "number";
	public static final String TABLE_COLOMN_BUY_NAME 					= "name";
	public static final String TABLE_COLOMN_BUY_MANUFACTURER 			= "manufacturer";
	//-------------------------------------------------------------------------------------
	
	// Название столбцов таблицы orings
	public static final String TABLE_COLOMN_ORINGS_ID 					= "id";
	public static final String TABLE_COLOMN_ORINGS_NAME 				= "name";
	public static final String TABLE_COLOMN_ORINGS_NUMBER 				= "number";
	public static final String TABLE_COLOMN_ORINGS_STANDART 			= "standart";
	public static final String TABLE_COLOMN_ORINGS_CROSS_SECTION 		= "cross_section";
	public static final String TABLE_COLOMN_ORINGS_INTERNAL_DIAMETER 	= "internal_diameter";
	//-------------------------------------------------------------------------------------
	
	// Название столбцов таблицы standart_parts
	public static final String TABLE_COLOMN_STP_ID 						= "id";
	public static final String TABLE_COLOMN_STP_NAME 					= "name";
	public static final String TABLE_COLOMN_STP_NUMBER 					= "number";
	public static final String TABLE_COLOMN_STP_STANDART 				= "standart";
	//-------------------------------------------------------------------------------------

	// Название столбцов таблицы number_prefixes 
	public static final String TABLE_COLOMN_NP_ID 						= "id";
	public static final String TABLE_COLOMN_NP_NAME 					= "name";
	public static final String TABLE_COLOMN_NP_DESCPIPTION 				= "description";
	//-------------------------------------------------------------------------------------
	
	// типы статусов для opp и asm
	public static final String OPP_ENTITY_TYPE_TASK 					= "TASK";
	public static final String OPP_ENTITY_TYPE_NOTE 					= "NOTE";
	public static final String OPP_ENTITY_TYPE_DESIGN 					= "DESIGN";
	//-------------------------------------------------------------------------------------

	// Название столбцов таблицы our_product_parts 
	public static final String TABLE_COLOMN_OPP_ID 						= "id";
	public static final String TABLE_COLOMN_OPP_NUMBER 					= "number";
	public static final String TABLE_COLOMN_OPP_NAME 					= "name";
	public static final String TABLE_COLOMN_OPP_STATUS 					= "status";
	public static final String TABLE_COLOMN_OPP_VERSION 				= "version";
	public static final String TABLE_COLOMN_OPP_UPDATE 					= "update";
	//-------------------------------------------------------------------------------------
	
	// Название столбцов таблицы assemblies
	public static final String TABLE_COLOMN_ASM_ID 						= "id";
	public static final String TABLE_COLOMN_ASM_NUMBER 					= "number";
	public static final String TABLE_COLOMN_ASM_NAME 					= "name";
	public static final String TABLE_COLOMN_ASM_STATUS					= "status";
	public static final String TABLE_COLOMN_ASM_VERSION 				= "version";
	public static final String TABLE_COLOMN_ASM_UPDATE 					= "update";
	//-------------------------------------------------------------------------------------
	
	
	
	// Название столбцов таблицы composition
	public static final String TABLE_COLOMN_COMPOSITION_ASM_ID			= "asm_id_full";
	public static final String TABLE_COLOMN_COMPOSITION_ENTITY_ID		= "id";
	public static final String TABLE_COLOMN_COMPOSITION_ENTITY_COUNTS	= "counts";
	public static final String TABLE_COLOMN_COMPOSITION_ENTITY_CHANGE 	= "change";
	//-------------------------------------------------------------------------------------	

	// RowMapper flags
	public static final String ROW_MAPPER_OPP						 	= "opp";
	public static final String ROW_MAPPER_ORING						 	= "oring";
	public static final String ROW_MAPPER_ASM					 		= "assembly";
	public static final String ROW_MAPPER_BUY						 	= "buy";
	public static final String ROW_MAPPER_STP						 	= "stp";
	public static final String ROW_MAPPER_VZK						 	= "vzk";
	public static final String ROW_MAPPER_SPEC						 	= "spec";
	public static final String ROW_MAPPER_PRODUCT						= "product";
	
	// Название столбцов таблицы product
	public static final String TABLE_COLOMN_PRODUCT_ID 					= "id"; 
	public static final String TABLE_COLOMN_PRODUCT_NUMBER 				= "number";
	public static final String TABLE_COLOMN_PRODUCT_NAME 				= "name";
	public static final String TABLE_COLOMN_PRODUCT_ASM_ID 				= "asm_id";
	public static final String TABLE_COLOMN_PRODUCT_DESCRIPTION			= "description";
	public static final String TABLE_COLOMN_PRODUCT_STATUS 				= "status";
	public static final String TABLE_COLOMN_PRODUCT_VERSION 			= "version";
	public static final String TABLE_COLOMN_PRODUCT_UPDATE 				= "update";
	public static final String TABLE_COLOMN_PRODUCT_DRAW_LINK			= "draw_link";
	//-------------------------------------------------------------------------------------	
	// Название столбцов таблицы 
	public static final String TABLE_COLOMN_SPECROW_ASM_FULL_ID 		= "asm_id_full";
	public static final String TABLE_COLOMN_SPECROW_ID 					= "id";
	public static final String TABLE_COLOMN_SPECROW_COUNTS 				= "counts";
	public static final String TABLE_COLOMN_SPECROW_CHANGE 				= "change";
	public static final String TABLE_COLOMN_SPECROW_TYPE 				= "type";
	//-------------------------------------------------------------------------------------

	
	
	public static boolean isThere(ResultSet rs, String column){
	    try{
	        rs.findColumn(column);
	        return true;
	    } catch (SQLException sqlex){
	        System.out.println("column doesn't exist {}, column = " + column);
	    }

	    return false;
	}
	
	
	
}
