package com.hydroyura.TechDocsSymbiosis.spec;

import java.util.List;
import java.util.Map;

import com.hydroyura.TechDocsSymbiosis.asm.AsmEntity;
import com.hydroyura.TechDocsSymbiosis.data.DataAsm;

public class SpecEntity {
	
	private AsmEntity asm;
	
	private List<DataAsm> opps, orings, buys, stps, vzks, asms;
	private Map<String, Integer> oppsMap, oringsMap, buysMap, stpsMap, vzksMap, asmsMap;
	
	
	public void printLists() {
		System.out.println("opps = " + opps);
		System.out.println("orings = " + orings);
		System.out.println("buys = " + buys);
		System.out.println("stps = " + stps);
		System.out.println("vzks = " + vzks);
		System.out.println("asms = " + asms);
	}
	
	

	@Override
	public String toString() {
		return "SpecEntity [asm=" + asm + ", opps=" + opps + ", orings=" + orings + ", buys=" + buys + ", stps=" + stps
				+ ", vzks=" + vzks + ", asms=" + asms + ", oppsMap=" + oppsMap + ", oringsMap=" + oringsMap
				+ ", buysMap=" + buysMap + ", stpsMap=" + stpsMap + ", vzksMap=" + vzksMap + ", asmsMap=" + asmsMap
				+ "]";
	}

	public AsmEntity getAsm() {
		return asm;
	}

	public List<DataAsm> getOpps() {
		return opps;
	}

	public Map<String, Integer> getOppsMap() {
		return oppsMap;
	}

	public Map<String, Integer> getOringsMap() {
		return oringsMap;
	}

	public Map<String, Integer> getBuysMap() {
		return buysMap;
	}

	public Map<String, Integer> getStpsMap() {
		return stpsMap;
	}

	public Map<String, Integer> getVzksMap() {
		return vzksMap;
	}

	public Map<String, Integer> getAsmsMap() {
		return asmsMap;
	}

	public void setOppsMap(Map<String, Integer> oppsMap) {
		this.oppsMap = oppsMap;
	}

	public void setOringsMap(Map<String, Integer> oringsMap) {
		this.oringsMap = oringsMap;
	}

	public void setBuysMap(Map<String, Integer> buysMap) {
		this.buysMap = buysMap;
	}

	public void setStpsMap(Map<String, Integer> stpsMap) {
		this.stpsMap = stpsMap;
	}

	public void setVzksMap(Map<String, Integer> vzksMap) {
		this.vzksMap = vzksMap;
	}

	public void setAsmsMap(Map<String, Integer> asmsMap) {
		this.asmsMap = asmsMap;
	}

	public List<DataAsm> getOrings() {
		return orings;
	}

	public List<DataAsm> getBuys() {
		return buys;
	}

	public List<DataAsm> getStps() {
		return stps;
	}

	public List<DataAsm> getVzks() {
		return vzks;
	}

	public List<DataAsm> getAsms() {
		return asms;
	}

	public void setAsm(AsmEntity asm) {
		this.asm = asm;
	}

	public void setOpps(List<DataAsm> opps) {
		this.opps = opps;
	}

	public void setOrings(List<DataAsm> orings) {
		this.orings = orings;
	}

	public void setBuys(List<DataAsm> buys) {
		this.buys = buys;
	}

	public void setStps(List<DataAsm> stps) {
		this.stps = stps;
	}

	public void setVzks(List<DataAsm> vzks) {
		this.vzks = vzks;
	}

	public void setAsms(List<DataAsm> asms) {
		this.asms = asms;
	}
	
}
