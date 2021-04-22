package com.hydroyura.TechDocsSymbiosis.DAOLayer.ForSpecRow;


/**
 * Ключ для сущности SpecificationRow
 * @autor Yury Klimchuk
*/
public class CompositeKeySpecRow {
	
	private long id, asmId;
	private String type;
	
	public CompositeKeySpecRow() {}
	
	public CompositeKeySpecRow(long id, long asmId, String type) {
		super();
		this.id = id;
		this.asmId = asmId;
		this.type = type;
	}



	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getAsmId() {
		return asmId;
	}
	
	public void setAsmId(long asmId) {
		this.asmId = asmId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

}
