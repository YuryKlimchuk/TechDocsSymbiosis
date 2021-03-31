package com.hydroyura.TechDocsSymbiosis.stp;

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
@RequestMapping("/stp")
public class StpController extends ControllerBasic<StpEntity>{
	
	@Autowired
	public StpController(@Qualifier("StpService")ServiceBasic<StpEntity> service) {
		super(service);
	}
	
	@PostConstruct
	public void init() {
	   INDEX = "stp/stp_index";
	   LIST_GET = "stp/stp_list";
	   LIST_POST = "redirect:stp/list";
	   EDIT_GET = "stp/stp_edit";
	   ADD_GET = "stp/stp_add";
	   ADD_POST = "redirect:stp/add";
	   DELETE_GET = "redirect:stp/edit";
	   EDIT_ITEM_GET = "stp/stp_edit_entity";
	   EDIT_ITEM_POST = "redirect:stp/edit/{id}";	
	}

	@Override
	public List<StpEntity> getItemsFiltered(@ModelAttribute("filter") ItemsListFilter filter) {
		if(filter.getStringMap().get("NAME") == null && filter.getStringMap().get("NUMBER") == null)
			return service.getItemsByNameAndNumber("", "");
		else return service.getItemsByNameAndNumber(filter.getStringMap().get("NAME"), filter.getStringMap().get("NUMBER")); 
	}

	@Override
	public String showAddGet(Model model) {
		model.addAttribute("item", new StpEntity());
		return ADD_GET;
	}
	
	
}