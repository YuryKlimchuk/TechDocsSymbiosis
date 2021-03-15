package com.hydroyura.TechDocsSymbiosis.spec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spec")
public class SpecController {
	
	
	@Autowired
	@Qualifier("SpecService")
	private SpecService specService;
	
	@GetMapping("/{id}")
	public String showSpecInfo(@PathVariable("id") long id, Model model) {
		
		
		model.addAttribute("spec", specService.getSpecInfo(id));
		
		return "/spec/spec_info";
	}

}
