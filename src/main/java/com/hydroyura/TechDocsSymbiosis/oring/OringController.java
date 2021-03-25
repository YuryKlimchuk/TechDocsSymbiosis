package com.hydroyura.TechDocsSymbiosis.oring;

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
@RequestMapping("/oring")
public class OringController extends ControllerBasic<OringEntity>{
	
	@Autowired
	public OringController(@Qualifier("OringService")ServiceBasic<OringEntity> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
	   INDEX = "/oring/oring_index";
	   LIST_GET = "/oring/oring_list";
	   LIST_POST = "redirect:/oring/list";
	   EDIT_GET = "/oring/oring_edit";
	   ADD_GET = "/oring/oring_add";
	   ADD_POST = "redirect:/oring/add";
	   DELETE_GET = "redirect:/oring/edit";
	   EDIT_ITEM_GET = "/oring/oring_edit_entity";
	   EDIT_ITEM_POST = "redirect:/oring/edit/{id}";
	   ITEM_IN_ASM_GET = "/oring/oring_in_asm";
	   ITEM_IN_ASM_POST = "redirect:/asm/edit_spec/{asmid}";
	}

	@Override
	public List<OringEntity> getItemsFiltered(@ModelAttribute("filter") ItemsListFilter filter) {
		if(filter.getStringMap().get("NAME") == null && filter.getStringMap().get("NUMBER") == null)
			return service.getItemsByNameAndNumber("", "");
		else return service.getItemsByNameAndNumber(filter.getStringMap().get("NAME"), filter.getStringMap().get("NUMBER")); 
	}

	@Override
	public String showAddGet(Model model) {
		model.addAttribute("item", new OringEntity());
		return ADD_GET;
	}
	
	
}