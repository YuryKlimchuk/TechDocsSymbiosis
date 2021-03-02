package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;

@Controller
@RequestMapping("/opp")
@SessionAttributes("listFilter")
public class OppController {
	
	
	@Autowired
	@Qualifier("OppServiceImpl")
	private ServiceInterface<OppEntity> service;
	

	@GetMapping("/index")
	public String showOppIndex() {
		return "/opp/opp_index";
	}
	
	@GetMapping("/list")
	public String showOppListGet() {
		return "/opp/opp_list";
	}
	
	@PostMapping("/list")
	public String showOppListPost() {
		return "/opp/opp_list";
	}

	
	@GetMapping("/edit")
	public String showOppEditGet() {
		return "/opp/opp_edit";
	}

	@ModelAttribute("listOpp")
	public List<OppEntity> getItemsBySearchFilter(@ModelAttribute("listFilter") OppFilter listFilter) {
		System.out.println("getItemsBySearchFilter: " + listFilter);
		return service.getItemsBySearchFilter(listFilter);
	}
	
	@ModelAttribute("listFilter")
	public OppFilter getFilter() {
		return new OppFilter();
		
	}
	
	@ModelAttribute("listOppFull")
	public List<OppEntity> getAll() {
		return service.getAll();
		
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * private OppServiceInterface oppService;
	 * 
	 * @Autowired public OppController(OppServiceInterfaceImpl oppService) {
	 * this.oppService = oppService; }
	 * 
	 * @GetMapping("/edit/{id}") public String showEditOppGet(@PathVariable("id")
	 * int id, Model model) { System.out.println("showEditOppGet"); Opp opp =
	 * oppService.getOppById(id); System.out.println("OPP ID = " + opp.getId());
	 * 
	 * model.addAttribute("opp", opp);
	 * 
	 * return "/opp/opp_edit"; }
	 */

