package com.hydroyura.TechDocsSymbiosis.Entities;

import java.util.HashMap;
import java.util.Map;

//Сущность для описания спецификации
public class Specification {

	// атрибуты главной сборки
	private Asm asm;

	// входящие элементы
	private Map<Opp, SpecificationRow> opps;
	
	// входящие элементы
	private Map<Oring, SpecificationRow> orings;
	
	// входящие элементы
	private Map<Vzk, SpecificationRow> vzks;
	
	// входящие элементы
	private Map<Buy, SpecificationRow> buys;
	
	// входящие элементы
	private Map<Stp, SpecificationRow> stps;
	
	// входящие элементы
	private Map<Asm, SpecificationRow> asms;

	
	public Specification() {
		opps = new HashMap<Opp, SpecificationRow>();
		orings = new HashMap<Oring, SpecificationRow>();
		vzks = new HashMap<Vzk, SpecificationRow>();
		buys = new HashMap<Buy, SpecificationRow>();
		stps = new HashMap<Stp, SpecificationRow>();
		asms = new HashMap<Asm, SpecificationRow>();
	}
	
	public Asm getAsm() {
		return asm;
	}

	public void setAsm(Asm asm) {
		this.asm = asm;
	}

	public Map<Opp, SpecificationRow> getOpps() {
		return opps;
	}

	public void setOpps(Map<Opp, SpecificationRow> opps) {
		this.opps = opps;
	}

	public Map<Oring, SpecificationRow> getOrings() {
		return orings;
	}

	public void setOrings(Map<Oring, SpecificationRow> orings) {
		this.orings = orings;
	}

	public Map<Vzk, SpecificationRow> getVzks() {
		return vzks;
	}

	public void setVzks(Map<Vzk, SpecificationRow> vzks) {
		this.vzks = vzks;
	}

	public Map<Buy, SpecificationRow> getBuys() {
		return buys;
	}

	public void setBuys(Map<Buy, SpecificationRow> buys) {
		this.buys = buys;
	}

	public Map<Stp, SpecificationRow> getStps() {
		return stps;
	}

	public void setStps(Map<Stp, SpecificationRow> stps) {
		this.stps = stps;
	}

	public Map<Asm, SpecificationRow> getAsms() {
		return asms;
	}

	public void setAsms(Map<Asm, SpecificationRow> asms) {
		this.asms = asms;
	}
	

	
}
