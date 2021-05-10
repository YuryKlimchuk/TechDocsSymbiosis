package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForPlanning;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.Entities.Asm;
import com.hydroyura.TechDocsSymbiosis.Entities.Buy;
import com.hydroyura.TechDocsSymbiosis.Entities.Opp;
import com.hydroyura.TechDocsSymbiosis.Entities.Oring;
import com.hydroyura.TechDocsSymbiosis.Entities.Product;
import com.hydroyura.TechDocsSymbiosis.Entities.Specification;
import com.hydroyura.TechDocsSymbiosis.Entities.SpecificationRow;
import com.hydroyura.TechDocsSymbiosis.Entities.Stp;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForSpecification.SpecificationService;

@Component("PlanningService")
public class PlanningService {
	
	@Autowired
	@Qualifier("SpecificationService")
	private SpecificationService specificationService;
	
	private Map<Product, Long> products;
	
	private Map<Specification, Long> specifications;
	
	@PostConstruct
	private void init() {
		this.products = new HashMap<Product, Long>();
		this.specifications = new HashMap<Specification, Long>();
	}

	public Map<Product, Long> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Long> products) {
		this.products = products;
	}

	public Map<Specification, Long> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(Map<Specification, Long> specifications) {
		this.specifications = specifications;
	}
	
	public Specification populateSpecificationsMap() {
		
		specifications.clear();
		
		// Перегоняем продукцию в спецификации
		for (Map.Entry<Product, Long> entry: getProducts().entrySet()) {

			Long count = entry.getValue();
			Long asmId = entry.getKey().getAsmId();
			
			Specification specification = specificationService.getSpecification(asmId);
			getSpecifications().put(specification, count);
		}
		
		Specification fullSpecification = new Specification();
		
		
		System.out.println("entrySet.size = " + getSpecifications().entrySet().size());
		// Перебор всех спецификаций
		for (Map.Entry<Specification, Long> specification : getSpecifications().entrySet()) {
			
			
			
			// Сборочки перебираем
			for (Map.Entry<Asm, SpecificationRow> asmRow: specification.getKey().getAsms().entrySet()) {
				Asm asmKey = asmRow.getKey();
				if(fullSpecification.getAsms().containsKey(asmKey)) {
					// Если полная спецификация уже содержит данную сборку
					long newCount = fullSpecification.getAsms().get(asmKey).getCount() + asmRow.getValue().getCount() * specification.getValue();
					fullSpecification.getAsms().get(asmKey).setCount(newCount);
					System.out.println("asm if");
					
				} else {
					SpecificationRow specificationRow = asmRow.getValue();
					specificationRow.setCount(specificationRow.getCount() * specification.getValue());
					fullSpecification.getAsms().put(asmKey, specificationRow);	
					System.out.println("asm else");
				}
			}
			
			// Детали перебираем
			for (Map.Entry<Opp, SpecificationRow> oppRow: specification.getKey().getOpps().entrySet()) {
				Opp oppKey = oppRow.getKey();
				if(fullSpecification.getOpps().containsKey(oppKey)) {
					// Если полная спецификация уже содержит данную сборку
					long newCount = fullSpecification.getOpps().get(oppKey).getCount() + oppRow.getValue().getCount() * specification.getValue();
					fullSpecification.getOpps().get(oppKey).setCount(newCount);
					System.out.println("opp if, " + oppKey.getNumber() + ", count = " + newCount);
					
				} else {
					SpecificationRow specificationRow = oppRow.getValue();
					long newCount = specificationRow.getCount() * specification.getValue();
					specificationRow.setCount(newCount);
					fullSpecification.getOpps().put(oppKey, specificationRow);	
					System.out.println("opp else, " + oppKey.getNumber() + ", count = " + newCount);
				}
			}
			
			// Оринги перебираем
			for (Map.Entry<Oring, SpecificationRow> oringRow: specification.getKey().getOrings().entrySet()) {
				Oring oringKey = oringRow.getKey();
				if(fullSpecification.getOrings().containsKey(oringKey)) {
					// Если полная спецификация уже содержит данную
					long newCount = fullSpecification.getOrings().get(oringKey).getCount() + oringRow.getValue().getCount() * specification.getValue();
					fullSpecification.getOrings().get(oringKey).setCount(newCount);
					
				} else {
					SpecificationRow specificationRow = oringRow.getValue();
					specificationRow.setCount(specificationRow.getCount() * specification.getValue());
					fullSpecification.getOrings().put(oringKey, specificationRow);	
				}
			}
			
			// vzk перебираем
			for (Map.Entry<Vzk, SpecificationRow> vzkRow: specification.getKey().getVzks().entrySet()) {
				Vzk vzkKey = vzkRow.getKey();
				if(fullSpecification.getVzks().containsKey(vzkKey)) {
					// Если полная спецификация уже содержит данную 
					long newCount = fullSpecification.getVzks().get(vzkKey).getCount() + vzkRow.getValue().getCount() * specification.getValue();
					fullSpecification.getVzks().get(vzkKey).setCount(newCount);
					
				} else {
					SpecificationRow specificationRow = vzkRow.getValue();
					specificationRow.setCount(specificationRow.getCount() * specification.getValue());
					fullSpecification.getVzks().put(vzkKey, specificationRow);	
				}
			}
			
			// stp перебираем
			for (Map.Entry<Stp, SpecificationRow> stpRow: specification.getKey().getStps().entrySet()) {
				Stp stpKey = stpRow.getKey();
				if(fullSpecification.getStps().containsKey(stpKey)) {
					// Если полная спецификация уже содержит данную
					long newCount = fullSpecification.getStps().get(stpKey).getCount() + stpRow.getValue().getCount() * specification.getValue();
					fullSpecification.getStps().get(stpKey).setCount(newCount);
					
				} else {
					SpecificationRow specificationRow = stpRow.getValue();
					specificationRow.setCount(specificationRow.getCount() * specification.getValue());
					fullSpecification.getStps().put(stpKey, specificationRow);	
				}
			}
			
			// buy перебираем
			for (Map.Entry<Buy, SpecificationRow> buyRow: specification.getKey().getBuys().entrySet()) {
				Buy buyKey = buyRow.getKey();
				if(fullSpecification.getBuys().containsKey(buyKey)) {
					// Если полная спецификация уже содержит данную
					long newCount = fullSpecification.getBuys().get(buyKey).getCount() + buyRow.getValue().getCount() * specification.getValue();
					fullSpecification.getBuys().get(buyKey).setCount(newCount);
					
				} else {
					SpecificationRow specificationRow = buyRow.getValue();
					specificationRow.setCount(specificationRow.getCount() * specification.getValue());
					fullSpecification.getBuys().put(buyKey, specificationRow);	
				}
			}
			
			
			
		}

		
		
		/*
		for (Map.Entry<Asm, SpecificationRow> entry: fullSpecification.getAsms().entrySet()) {
			System.out.println(entry.getKey().getNumber() + " " + entry.getValue().getCount());
		}
		for (Map.Entry<Opp, SpecificationRow> entry: fullSpecification.getOpps().entrySet()) {
			System.out.println(entry.getKey().getNumber() + " " + entry.getValue().getCount());
		}
		System.out.println("-----------------------------------------------------------------");
		*/
		
		return specificationService.getDetailSpecification(fullSpecification);
		
	}
	
	
}
