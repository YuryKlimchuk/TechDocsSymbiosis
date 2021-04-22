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
import com.hydroyura.TechDocsSymbiosis.Entities.Stp;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.OppFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.StpFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.VzkFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;

@Controller
@RequestMapping("/vzk")
public class VzkController extends BaseEntityController<Vzk> {
	
	@Autowired
	public VzkController(@Qualifier("VzkService") BasicServiceForEntity<Vzk> service) {
		super(service);
	}

	@PostConstruct
	private void init() {
		
		TYPE = Constants.ROW_MAPPER_VZK;
		
		INDEX_GET = "vzk/vzk_index";
		LIST_GET = "vzk/vzk_list";
		LIST_POST = "redirect:/vzk/list";
		EDIT_GET = "vzk/vzk_edit";
		DETAIL_GET = "vzk/vzk_detail";
		EDIT_ADD_GET = "vzk/vzk_add";
		EDIT_ADD_POST = "redirect:/vzk/edit/add";
		EDIT_DELETE_GET = "redirect:/vzk/edit";
		EDIT_UPDATE_GET = "vzk/vzk_update";
		EDIT_UPDATE_POST = "redirect:/vzk/edit/";
	}
	
	
	@Override
	public String showEditAddGet(Model model) {
		model.addAttribute("item", new Vzk());
		return EDIT_ADD_GET;
	}

	@Override
	public Filter<Vzk> getFilter() {
		Filter<Vzk> filter = new VzkFilter();
		return filter;
	}

	@Override
	public String showListGet(Model model) {
		
		Filter filter;
		filter = (VzkFilter) model.getAttribute("filter");
		if(filter == null) {
			filter = new OppFilter();
			model.addAttribute("filter", filter);
		}
		System.out.println("showListGet() - " + filter);
		model.addAttribute("items", service.getFilteredEntities((Filter<Vzk>) filter));
		return LIST_GET;
	}

	@PostMapping("/list")
	public String showListGet(@ModelAttribute("filter") VzkFilter filter, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filter", filter);
		return LIST_POST;
	}
	
}
