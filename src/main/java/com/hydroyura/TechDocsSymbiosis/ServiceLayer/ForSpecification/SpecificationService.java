package com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.BasicDAOInterface;
import com.hydroyura.TechDocsSymbiosis.DAOLayer.ForSpecRow.CompositeKeySpecRow;
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;
import com.hydroyura.TechDocsSymbiosis.Entities.Buy;
import com.hydroyura.TechDocsSymbiosis.Entities.Opp;
import com.hydroyura.TechDocsSymbiosis.Entities.Oring;
import com.hydroyura.TechDocsSymbiosis.Entities.Specification;
import com.hydroyura.TechDocsSymbiosis.Entities.SpecificationRow;
import com.hydroyura.TechDocsSymbiosis.Entities.Stp;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;

@Component("SpecificationService")
public class SpecificationService {
	
	@Autowired
	@Qualifier("AsmDAO")
	private BasicDAOInterface<Asm, Long> asmDAO;
	
	@Autowired
	@Qualifier("OppDAO")
	private BasicDAOInterface<Opp, Long> oppDAO;
	
	@Autowired
	@Qualifier("StpDAO")
	private BasicDAOInterface<Stp, Long> stpDAO;
	
	@Autowired
	@Qualifier("OringDAO")
	private BasicDAOInterface<Oring, Long> oringDAO;
	
	@Autowired
	@Qualifier("BuyDAO")
	private BasicDAOInterface<Buy, Long> buyDAO;
	
	@Autowired
	@Qualifier("VzkDAO")
	private BasicDAOInterface<Vzk, Long> vzkDAO;
	
	@Autowired
	@Qualifier("SpecRowDAO")
	private BasicDAOInterface<SpecificationRow, CompositeKeySpecRow> specRowDAO;

	
	/**
	 * @return Спецификацию по заданному id сборки.
	 * @param Long asmId уникальный номер сборки.
	 */
	public Specification getSpecification(Long asmId) {
		Specification specification = new Specification();
		List<SpecificationRow> elements = specRowDAO.getAllEntities();
		
		for (SpecificationRow item : elements) {
			if(item.getAsmId() == asmId) {
				switch (item.getRowType()) {
				case "opp":
					specification.getOpps().put(oppDAO.getEntity(item.getElementId()), item);
					break;
				case "asm":
					specification.getAsms().put(asmDAO.getEntity(item.getElementId()), item);
					break;					
				case "stp":
					specification.getStps().put(stpDAO.getEntity(item.getElementId()), item);
					break;
				case "oring":
					specification.getOrings().put(oringDAO.getEntity(item.getElementId()), item);
					break;
				case "buy":
					specification.getBuys().put(buyDAO.getEntity(item.getElementId()), item);
					break;
				case "vzk":
					specification.getVzks().put(vzkDAO.getEntity(item.getElementId()), item);
					break;
				}

			}
		}
		
		specification.setAsm(asmDAO.getEntity(asmId));
		return specification;
	}
	
	
	/**
	 * @return Развернутую спецификацию (спецификация в которой все сборки раскрыты) по заданному id сборки.
	 * @param Long asmId уникальный номер сборки.
	 */
	public Specification getDetailSpecification(Long asmId) {
		Specification specification = getSpecification(asmId);
		
		while (!specification.getAsms().isEmpty()) {
			
			Map<Asm, SpecificationRow> asmMapBuffer = new HashMap<Asm, SpecificationRow>(specification.getAsms());
			specification.getAsms().clear();
			
			for (Map.Entry<Asm, SpecificationRow> entry : asmMapBuffer.entrySet()) {
				Specification innerSpecification = getSpecification(entry.getKey().getId());

				long higerlevelcount = entry.getValue().getCount();

				for (Map.Entry<Opp, SpecificationRow> innerEntry : innerSpecification.getOpps().entrySet()) {
					if(specification.getOpps().containsKey(innerEntry.getKey())) {
						long count = specification.getOpps().get(innerEntry.getKey()).getCount();
						count = count + (innerEntry.getValue().getCount() * higerlevelcount);
						specification.getOpps().get(innerEntry.getKey()).setCount(count);
						System.out.println("111");
					} else {
						SpecificationRow row = innerEntry.getValue();
						row.setCount(row.getCount() * higerlevelcount);
						specification.getOpps().put(innerEntry.getKey(), row);
					}
				}
				
				for (Map.Entry<Oring, SpecificationRow> innerEntry : innerSpecification.getOrings().entrySet()) {
					if(specification.getOrings().containsKey(innerEntry.getKey())) {
						long count = specification.getOrings().get(innerEntry.getKey()).getCount();
						count = count + (innerEntry.getValue().getCount() * higerlevelcount) ;
						specification.getOrings().get(innerEntry.getKey()).setCount(count);
						System.out.println("222");
					} else {
						SpecificationRow row = innerEntry.getValue();
						row.setCount(row.getCount() * higerlevelcount);
						specification.getOrings().put(innerEntry.getKey(), row);
					}
				}
				
				for (Map.Entry<Stp, SpecificationRow> innerEntry : innerSpecification.getStps().entrySet()) {
					if(specification.getStps().containsKey(innerEntry.getKey())) {
						long count = specification.getStps().get(innerEntry.getKey()).getCount();
						count = count + (innerEntry.getValue().getCount() * higerlevelcount);
						specification.getStps().get(innerEntry.getKey()).setCount(count);
						System.out.println("333");
					} else {
						SpecificationRow row = innerEntry.getValue();
						row.setCount(row.getCount() * higerlevelcount);
						specification.getStps().put(innerEntry.getKey(), row);
					}
				}
				
				for (Map.Entry<Buy, SpecificationRow> innerEntry : innerSpecification.getBuys().entrySet()) {
					if(specification.getBuys().containsKey(innerEntry.getKey())) {
						long count = specification.getBuys().get(innerEntry.getKey()).getCount();
						count = count + (innerEntry.getValue().getCount() * higerlevelcount);
						specification.getBuys().get(innerEntry.getKey()).setCount(count);
						System.out.println("444");
					} else {
						SpecificationRow row = innerEntry.getValue();
						row.setCount(row.getCount() * higerlevelcount);
						specification.getBuys().put(innerEntry.getKey(), row);
					}
				}
				
				for (Map.Entry<Vzk, SpecificationRow> innerEntry : innerSpecification.getVzks().entrySet()) {
					if(specification.getVzks().containsKey(innerEntry.getKey())) {
						long count = specification.getVzks().get(innerEntry.getKey()).getCount();
						count = count + (innerEntry.getValue().getCount() * higerlevelcount);
						specification.getVzks().get(innerEntry.getKey()).setCount(count);
						System.out.println("666");
					} else {
						SpecificationRow row = innerEntry.getValue();
						row.setCount(row.getCount() * higerlevelcount);
						specification.getVzks().put(innerEntry.getKey(), row);
					}
				}
				
				
				for (Map.Entry<Asm, SpecificationRow> innerEntry : innerSpecification.getAsms().entrySet()) {
					if(specification.getAsms().containsKey(innerEntry.getKey())) {
						long count = specification.getAsms().get(innerEntry.getKey()).getCount();
						count = count + (innerEntry.getValue().getCount() * higerlevelcount);
						specification.getAsms().get(innerEntry.getKey()).setCount(count);
						System.out.println("777");
					} else {
						SpecificationRow row = innerEntry.getValue();
						row.setCount(row.getCount() * higerlevelcount);
						specification.getAsms().put(innerEntry.getKey(), row);
					}
				}
				
				
			}
		}
		
		
		return specification;
	}


	public long deleteRowFromSpecification(CompositeKeySpecRow key) {
		return specRowDAO.delete(key);
	}
	
	public long addRowInSpecification(SpecificationRow row) {
		return specRowDAO.addEntity(row);
	}


	public List<Opp> getOppList() {
		return oppDAO.getAllEntities();
	}
	
	public List<Asm> getAsmList() {
		return asmDAO.getAllEntities();
	}
	
	public List<Buy> getBuyList() {
		return buyDAO.getAllEntities();
	}
	
	public List<Stp> getStpList() {
		return stpDAO.getAllEntities();
	}
	
	public List<Vzk> getVzkList() {
		return vzkDAO.getAllEntities();
	}
	
	public List<Oring> getOringList() {
		return oringDAO.getAllEntities();
	}
}
