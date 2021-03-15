package com.hydroyura.TechDocsSymbiosis.opp;

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
@RequestMapping("/opp")
public class OppController extends ControllerBasic<OppEntity>{
	
	@Autowired
	public OppController(@Qualifier("OppService") ServiceBasic<OppEntity> service) {
		super(service);
	}

	@PostConstruct
	public void init() {
	   INDEX = "/opp/opp_index";
	   LIST_GET = "/opp/opp_list";
	   LIST_POST = "redirect:/opp/list";
	   EDIT_GET = "/opp/opp_edit";
	   ADD_GET = "/opp/opp_add";
	   ADD_POST = "redirect:/opp/add";
	   DELETE_GET = "redirect:/opp/edit";
	   EDIT_ITEM_GET = "/opp/opp_edit_entity";
	   EDIT_ITEM_POST = "redirect:/opp/edit/{id}";	
	}

	@Override
	public List<OppEntity> getItemsFiltered(@ModelAttribute("filter") ItemsListFilter filter) {
		if(filter.getStringMap().get("NAME") == null && filter.getStringMap().get("NUMBER") == null)
			return service.getItemsByNameAndNumber("", "");
		else return service.getItemsByNameAndNumber(filter.getStringMap().get("NAME"), filter.getStringMap().get("NUMBER")); 
	}

	@Override
	public String showAddGet(Model model) {
		model.addAttribute("item", new OppEntity());
		return ADD_GET;
	}

}	


