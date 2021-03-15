package com.hydroyura.TechDocsSymbiosis.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hydroyura.TechDocsSymbiosis.opp.OppService;
import com.hydroyura.TechDocsSymbiosis.oring.OringService;

@Controller
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	@Qualifier("OppService")
	private OppService oppService;
	
	@Autowired
	@Qualifier("OringService")
	private OringService oringService;
	
	
	@Autowired
	@Qualifier("DataService")
	private DataService dataService;
	
	
	@GetMapping("/{type}/{id}")
	public String showDataGet(
			@PathVariable("type") String type, 
			@PathVariable("id") long id, Model model) {
		
		String str = null;
		

		
		switch (type) {
		case "opp":
			model.addAttribute("item", oppService.getItem(id));
			model.addAttribute("oppInAsms", dataService.getOppInAsm(id));
			str = "/data/opp_data";
			break;
		case "oring":
			model.addAttribute("item", oringService.getItem(id));
			model.addAttribute("oringInAsms", dataService.getOringInAsm(id));
			str = "/data/oring_data";
			break;
		}
		
		model.addAttribute("type", type);
		model.addAttribute("id", id);
		
		model.addAttribute("oppInAsms", dataService.getOppInAsm(id));
		
		return str;
	}

}
