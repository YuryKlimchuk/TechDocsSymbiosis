package com.hydroyura.TechDocsSymbiosis.buy;

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
@RequestMapping("/buy")
public class BuyController extends ControllerBasic<BuyEntity>{
	
	@Autowired
	public BuyController(@Qualifier("BuyService") ServiceBasic<BuyEntity> service) {
		super(service);
	}

	@PostConstruct
	public void init() {
	   INDEX = "buy/buy_index";
	   LIST_GET = "buy/buy_list";
	   LIST_POST = "redirect:buy/list";
	   EDIT_GET = "buy/buy_edit";
	   ADD_GET = "buy/buy_add";
	   ADD_POST = "redirect:buy/add";
	   DELETE_GET = "redirect:buy/edit";
	   EDIT_ITEM_GET = "buy/buy_edit_entity";
	   EDIT_ITEM_POST = "redirect:buy/edit/{id}";	
	}

	@Override
	public List<BuyEntity> getItemsFiltered(@ModelAttribute("filter") ItemsListFilter filter) {
		if(filter.getStringMap().get("NAME") == null && filter.getStringMap().get("NUMBER") == null)
			return service.getItemsByNameAndNumber("", "");
		else return service.getItemsByNameAndNumber(filter.getStringMap().get("NAME"), filter.getStringMap().get("NUMBER")); 
	}

	@Override
	public String showAddGet(Model model) {
		model.addAttribute("item", new BuyEntity());
		return ADD_GET;
	}

}	


