package com.hydroyura.TechDocsSymbiosis.Controllers.ForEntity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Buy;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.BuyFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.OppFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.VzkFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;

@Controller
@RequestMapping("/buy")
public class BuyController extends BaseEntityController<Buy> {
	
	@Autowired
	public BuyController(@Qualifier("BuyService") BasicServiceForEntity<Buy> service) {
		super(service);
	}

	@PostConstruct
	private void init() {
		
		TYPE = Constants.ROW_MAPPER_BUY;
		
		INDEX_GET = "buy/buy_index";
		LIST_GET = "buy/buy_list";
		LIST_POST = "redirect:/buy/list";
		EDIT_GET = "buy/buy_edit";
		DETAIL_GET = "buy/buy_detail";
		EDIT_ADD_GET = "buy/buy_add";
		EDIT_ADD_POST = "redirect:/buy/edit/add";
		EDIT_DELETE_GET = "redirect:/buy/edit";
		EDIT_UPDATE_GET = "buy/buy_update";
		EDIT_UPDATE_POST = "redirect:/buy/edit/";
	}
	
	
	@Override
	public String showEditAddGet(Model model) {
		model.addAttribute("item", new Buy());
		return EDIT_ADD_GET;
	}

	@Override
	public Filter<Buy> getFilter() {
		Filter<Buy> filter = new BuyFilter();
		return filter;
	}

	@Override
	public String showListGet(Model model) {
		
		Filter filter;
		filter = (BuyFilter) model.getAttribute("filter");
		if(filter == null) {
			filter = new BuyFilter();
			model.addAttribute("filter", filter);
		}
		System.out.println("showListGet() - " + filter);
		model.addAttribute("items", service.getFilteredEntities((Filter<Buy>) filter));
		return LIST_GET;
	}

	@PostMapping("/list")
	public String showListGet(@ModelAttribute("filter") BuyFilter filter, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filter", filter);
		return LIST_POST;
	}
	
}
