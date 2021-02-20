package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/oring")
public class OringController {
	
	private OringServiceInterfaceImpl oringService;
	
	@Autowired
	public OringController(OringServiceInterfaceImpl oringService) {
		this.oringService = oringService;
	}


	@GetMapping("/index")
	public String showOringIndex(Model model) {
		return "/oring/oring_index";
	}
	
	
	@GetMapping("/list")
	public String showOringListGet(Model model) {
		
		OringFilter oringFilter;
		
		if(model.getAttribute("oringFilter") == null) {
			oringFilter = new OringFilter(); 
			oringFilter.setMinInnerDiameter(oringService.getMinInnerDiameter());
			oringFilter.setMaxInnerDiameter(oringService.getMaxInnerDiameter());
			model.addAttribute("oringFilter", oringFilter);
		} else {
			oringFilter = (OringFilter) model.getAttribute("oringFilter");
		}		
		model.addAttribute("orings", oringService.getOringListByFilter(oringFilter));
		return "/oring/oring_list";
	}
	
	@PostMapping("/list")
	public String showOringListPost(@ModelAttribute("oringFilter") OringFilter oringFilter, RedirectAttributes redirectAttributes, Model model) {
		redirectAttributes.addFlashAttribute("oringFilter", oringFilter);
		return "redirect:/oring/list";
	}
	
	
	@ModelAttribute("crossSectionEnable")
	public List<Float> getCrossSectionEnable() {
		return oringService.getCrossSectionList();
	}
	
}