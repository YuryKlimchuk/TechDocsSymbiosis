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
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.OppFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.StpFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;

@Controller
@RequestMapping("/stp")
public class StpController extends BaseEntityController<Stp> {
	
	@Autowired
	public StpController(@Qualifier("StpService") BasicServiceForEntity<Stp> service) {
		super(service);
	}

	@PostConstruct
	private void init() {
		
		TYPE = Constants.ROW_MAPPER_STP;
		
		INDEX_GET = "stp/stp_index";
		LIST_GET = "stp/stp_list";
		LIST_POST = "redirect:/stp/list/";
		EDIT_GET = "stp/stp_edit";
		DETAIL_GET = "stp/stp_detail";
		EDIT_ADD_GET = "stp/stp_add";
		EDIT_ADD_POST = "redirect:/stp/edit/add/";
		EDIT_DELETE_GET = "redirect:/stp/edit/";
		EDIT_UPDATE_GET = "stp/stp_update";
		EDIT_UPDATE_POST = "redirect:/stp/edit/";
	}
	
	
	@Override
	public String showEditAddGet(Model model) {
		model.addAttribute("item", new Stp());
		return EDIT_ADD_GET;
	}

	@Override
	public Filter<Stp> getFilter() {
		Filter<Stp> filter = new StpFilter();
		return filter;
	}

	@Override
	public String showListGet(Model model) {
		
		Filter filter;
		filter = (StpFilter) model.getAttribute("filter");
		if(filter == null) {
			filter = new OppFilter();
			model.addAttribute("filter", filter);
		}
		System.out.println("showListGet() - " + filter);
		model.addAttribute("items", service.getFilteredEntities((Filter<Stp>) filter));
		return LIST_GET;
	}

	@PostMapping("/list")
	public String showListGet(@ModelAttribute("filter") StpFilter filter, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filter", filter);
		return LIST_POST;
	}
	
}
