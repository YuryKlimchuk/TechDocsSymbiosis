package com.hydroyura.TechDocsSymbiosis.asm.partofasm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;
import com.hydroyura.TechDocsSymbiosis.init.Constants;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;



@Controller
@RequestMapping("/partofasm")
public class PartOfAsmController {
	
	
	@Autowired
	@Qualifier("PartOfAsmServiceImpl")
	private ServiceInterface<PartOfAsmEntity> service; 
	
	@Autowired
	@Qualifier("OppServiceImpl")
	private ServiceInterface<OppEntity> oppService; 


	

	@GetMapping("/index/{id}")
	public String showEntityIndexGet(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id);
		
		List<PartOfAsmEntity> oppParts = service.getAllFromTableByIntCreteria(Constants.TABLE_NAME_ASM_COMP_OPP, id);
		System.out.println(oppParts);
		

		
		
		return "/partofasm/partofasm_index";
	}
	
	
}
