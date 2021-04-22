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
import com.hydroyura.TechDocsSymbiosis.Entities.Oring;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.OppFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.OringFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;

@Controller
@RequestMapping("/oring")
public class OringController extends BaseEntityController<Oring> {
	
	@Autowired
	public OringController(@Qualifier("OringService") BasicServiceForEntity<Oring> service) {
		super(service);
	}

	@PostConstruct
	private void init() {
		
		TYPE = Constants.ROW_MAPPER_ORING;
		
		INDEX_GET = "oring/oring_index";
		LIST_GET = "oring/oring_list";
		LIST_POST = "redirect:/oring/list";
		EDIT_GET = "oring/oring_edit";
		DETAIL_GET = "oring/oring_detail";
		EDIT_ADD_GET = "oring/oring_add";
		EDIT_ADD_POST = "redirect:/oring/edit/add";
		EDIT_DELETE_GET = "redirect:/oring/edit";
		EDIT_UPDATE_GET = "oring/oring_update";
		EDIT_UPDATE_POST = "redirect:/oring/edit/";
	}
	
	
	@Override
	public String showEditAddGet(Model model) {
		model.addAttribute("item", new Oring());
		return EDIT_ADD_GET;
	}

	@Override
	public Filter<Oring> getFilter() {
		Filter<Oring> oringFilter = new OringFilter();
		return oringFilter;
	}

	@Override
	public String showListGet(Model model) {
		
		Filter filter;
		filter = (OringFilter) model.getAttribute("filter");
		if(filter == null) {
			filter = new OppFilter();
			model.addAttribute("filter", filter);
		}
		System.out.println("showListGet() - " + filter);
		model.addAttribute("items", service.getFilteredEntities((Filter<Oring>) filter));
		return LIST_GET;
	}

	@PostMapping("/list")
	public String showListGet(@ModelAttribute("filter") OringFilter filter, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filter", filter);
		return LIST_POST;
	}
	
}
