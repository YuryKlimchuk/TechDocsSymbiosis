package com.hydroyura.TechDocsSymbiosis.Controllers.ForEntity;

import java.util.HashMap;
import java.util.Map;

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
import com.hydroyura.TechDocsSymbiosis.Entities.Opp;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.OppFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;

@Controller
@RequestMapping("/opp")
public class OppController extends BaseEntityController<Opp> {
	
	@Autowired
	public OppController(@Qualifier("OppService") BasicServiceForEntity<Opp> service) {
		super(service);
	}

	@PostConstruct
	private void init() {
		
		TYPE = Constants.ROW_MAPPER_OPP;
		
		INDEX_GET = "opp/opp_index";
		LIST_GET = "opp/opp_list";
		LIST_POST = "redirect:/opp/list/";
		EDIT_GET = "opp/opp_edit";
		DETAIL_GET = "opp/opp_detail";
		EDIT_ADD_GET = "opp/opp_add";
		EDIT_ADD_POST = "redirect:/opp/edit/add/";
		EDIT_DELETE_GET = "redirect:/opp/edit/";
		EDIT_UPDATE_GET = "opp/opp_update";
		EDIT_UPDATE_POST = "redirect:/opp/edit/";
	}
	
	
	@Override
	public String showEditAddGet(Model model) {
		model.addAttribute("item", new Opp());
		return EDIT_ADD_GET;
	}

	@Override
	public Filter<Opp> getFilter() {
		Filter<Opp> oppFilter = new OppFilter();
		return oppFilter;
	}

	@Override
	public String showListGet(Model model) {
		
		OppFilter filter;
		filter = (OppFilter) model.getAttribute("filter");
		if(filter == null) {
			System.out.println(".!.");
			filter = new OppFilter();
			Map<String, Boolean> status = new HashMap<String, Boolean>();
			status.put("TASK", true);
			status.put("DESIGN", true);
			status.put("NOTE", true);
			model.addAttribute("filter", filter);
		}
		
		
		System.out.println("showListGet() - " + filter);

		
		model.addAttribute("items", service.getFilteredEntities((Filter<Opp>) filter));
		
		return LIST_GET;
	}

	@PostMapping("/list")
	public String showListGet(@ModelAttribute("filter") OppFilter filter, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filter", filter);
		return LIST_POST;
	}
	
	/*
	@GetMapping("/list")
	public String showListGet(Model model) {
		@SuppressWarnings("unchecked")
		Filter<T> filter;
		filter = (Filter<T>) model.getAttribute("filter");
		if(filter == null) {
			filter = (Filter<T>) new OppListFilter();
		}
		
		
		model.addAttribute("items", service.getFilteredEntities(null));
		return LIST_GET;
	};
	*/

}
