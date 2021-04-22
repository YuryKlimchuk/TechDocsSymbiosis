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
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;
import com.hydroyura.TechDocsSymbiosis.Entities.Opp;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.AsmFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;

@Controller
@RequestMapping("/asm")
public class AsmController extends BaseEntityController<Asm> {
	
	@Autowired
	public AsmController(@Qualifier("AsmService") BasicServiceForEntity<Asm> service) {
		super(service);
	}

	@PostConstruct
	private void init() {
		
		TYPE = Constants.ROW_MAPPER_ASM;
		
		INDEX_GET = "asm/asm_index";
		LIST_GET = "asm/asm_list";
		LIST_POST = "redirect:/asm/list";
		EDIT_GET = "asm/asm_edit";
		DETAIL_GET = "asm/asm_detail";
		EDIT_ADD_GET = "asm/asm_add";
		EDIT_ADD_POST = "redirect:/asm/edit/add";
		EDIT_DELETE_GET = "redirect:/asm/edit";
		EDIT_UPDATE_GET = "asm/asm_update";
		EDIT_UPDATE_POST = "redirect:/asm/edit/";
	}
	
	
	@Override
	public String showEditAddGet(Model model) {
		model.addAttribute("item", new Asm());
		return EDIT_ADD_GET;
	}

	@Override
	public Filter<Asm> getFilter() {
		Filter<Asm> filter = new AsmFilter();
		return filter;
	}

	@Override
	public String showListGet(Model model) {
		
		AsmFilter filter;
		filter = (AsmFilter) model.getAttribute("filter");
		if(filter == null) {
			filter = new AsmFilter();
			model.addAttribute("filter", filter);
		}
		
		
		System.out.println("showListGet() - " + filter);

		
		model.addAttribute("items", service.getFilteredEntities((Filter<Asm>) filter));
		
		return LIST_GET;
	}

	@PostMapping("/list")
	public String showListGet(@ModelAttribute("filter") AsmFilter filter, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filter", filter);
		return LIST_POST;
	}


}
