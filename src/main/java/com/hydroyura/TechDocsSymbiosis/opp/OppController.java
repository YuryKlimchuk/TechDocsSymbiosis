package com.hydroyura.TechDocsSymbiosis.opp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/opp")
public class OppController {
	
	private OppServiceInterface oppService;
	
	@Autowired
	public OppController(OppServiceInterfaceImpl oppService) {
		this.oppService = oppService;
	}
	
	
	@GetMapping("/index")
	public String showOppIndex() {
		return "/opp/opp_index";
	}
	
	
	@GetMapping("/list")
	public String showOppListGet(Model model) {
		OppFilter oppFilter = null;
		
		model.addAttribute("opps", oppService.getOppListByFilter(oppFilter));
		return "/opp/opp_list";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditOppGet(@PathVariable("id") int id, Model model) {	
		System.out.println("showEditOppGet");
		Opp opp = oppService.getOppById(id);
		System.out.println("OPP ID = " + opp.getId());
	
		model.addAttribute("opp", opp);
		
		return "/opp/opp_edit";
	}

}
