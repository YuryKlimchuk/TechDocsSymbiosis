package com.hydroyura.TechDocsSymbiosis.spec;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/spec")
@SessionAttributes("spec")
public class SpecController {
	
	
	@Autowired
	@Qualifier("SpecService")
	private SpecService specService;
	
	@GetMapping("/{id}")
	public String showSpecInfo(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
		SpecEntity spec = specService.getSpecInfo(id);
		model.addAttribute("spec", spec);
		redirectAttributes.addFlashAttribute("spec", spec);
		return "/spec/spec_info";
	}
	
	@GetMapping("/detailed/{id}")
	public String showSpecDetailedInfo(@PathVariable("id") int id, @ModelAttribute("spec") SpecEntity spec, Model model) {
		model.addAttribute("id", id);
		
		System.out.println(spec.getAsm().getNumber());
		spec.printLists();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		specService.getDetailedPartList(spec, map);
		
		
		model.addAttribute("map", map);
		
		/*
		 * 
		 * 	List sortedKeys=new ArrayList(yourMap.keySet());
			Collections.sort(sortedKeys);
			// Do what you need with sortedKeys.
		 * 
		 * Добавим здесь сортировку....
		 * 
		 * 
		 */
		
		
		return "/spec/spec_detailed_info";
	}

}
