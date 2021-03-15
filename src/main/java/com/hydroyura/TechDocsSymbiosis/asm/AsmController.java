package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hydroyura.TechDocsSymbiosis.basicclasses.ControllerBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ItemsListFilter;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;

@Controller
@RequestMapping("/asm")
public class AsmController extends ControllerBasic<AsmEntity>{
	
	@Autowired
	public AsmController(@Qualifier("AsmService") ServiceBasic<AsmEntity> service) {
		super(service);
	}

	@PostConstruct
	public void init() {
	   INDEX = "/asm/asm_index";
	   LIST_GET = "/asm/asm_list";
	   LIST_POST = "redirect:/asm/list";
	   EDIT_GET = "/asm/asm_edit";
	   ADD_GET = "/asm/asm_add";
	   ADD_POST = "redirect:/asm/add";
	   DELETE_GET = "redirect:/asm/edit";
	   EDIT_ITEM_GET = "/asm/asm_edit_entity";
	   EDIT_ITEM_POST = "redirect:/asm/edit/{id}";	
	}

	@Override
	public List<AsmEntity> getItemsFiltered(@ModelAttribute("filter") ItemsListFilter filter) {
		if(filter.getStringMap().get("NAME") == null && filter.getStringMap().get("NUMBER") == null)
			return service.getItemsByNameAndNumber("", "");
		else return service.getItemsByNameAndNumber(filter.getStringMap().get("NAME"), filter.getStringMap().get("NUMBER")); 
	}

	@Override
	public String showAddGet(Model model) {
		model.addAttribute("item", new AsmEntity());
		return ADD_GET;
	}

}	


