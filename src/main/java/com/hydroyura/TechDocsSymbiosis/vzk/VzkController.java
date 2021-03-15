package com.hydroyura.TechDocsSymbiosis.vzk;

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
@RequestMapping("/vzk")
public class VzkController extends ControllerBasic<VzkEntity>{
	
	@Autowired
	public VzkController(@Qualifier("VzkService")ServiceBasic<VzkEntity> service) {
		super(service);
	}
	
	@PostConstruct
	public void init() {
	   INDEX = "/vzk/vzk_index";
	   LIST_GET = "/vzk/vzk_list";
	   LIST_POST = "redirect:/vzk/list";
	   EDIT_GET = "/vzk/vzk_edit";
	   ADD_GET = "/vzk/vzk_add";
	   ADD_POST = "redirect:/vzk/add";
	   DELETE_GET = "redirect:/vzk/edit";
	   EDIT_ITEM_GET = "/vzk/vzk_edit_entity";
	   EDIT_ITEM_POST = "redirect:/vzk/edit/{id}";	
	}

	@Override
	public List<VzkEntity> getItemsFiltered(@ModelAttribute("filter") ItemsListFilter filter) {
		if(filter.getStringMap().get("NAME") == null && filter.getStringMap().get("NUMBER") == null)
			return service.getItemsByNameAndNumber("", "");
		else return service.getItemsByNameAndNumber(filter.getStringMap().get("NAME"), filter.getStringMap().get("NUMBER")); 
	}

	@Override
	public String showAddGet(Model model) {
		model.addAttribute("item", new VzkEntity());
		return ADD_GET;
	}
	
	
}