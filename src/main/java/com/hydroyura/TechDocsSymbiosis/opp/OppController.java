package com.hydroyura.TechDocsSymbiosis.opp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/edit/{id}")
	public String showOppEditEntityGet(@PathVariable("id") int id, Model model) {
		model.addAttribute("editableOpp", service.getItemById(id));
		return "/opp/opp_edit_entity";
	}
	
	@PostMapping("/edit/{id}")
	public String showOppEditEntityPost(@PathVariable("id") int id, 
										@ModelAttribute("editableOpp") OppEntity editableOpp, Model model) {
		service.changeItem(id, editableOpp);
		return "redirect:/opp/edit/{id}";
	}
	
	
	@GetMapping("/add")
	public String showOppAddGet(Model model) {
		
		System.out.println("КУ_КУ_ЕПТА " + model.getAttribute("msg"));
		
		model.addAttribute("opp", new OppEntity());
		return "/opp/opp_add";
	}
	
	@PostMapping("/add")
	public String showOppAddPost(@ModelAttribute("opp") OppEntity opp, RedirectAttributes redirectAttributes) {
		if(service.addItem(opp)) {
			redirectAttributes.addFlashAttribute("msg", "Элемент добавлен успешно");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Добавить элемент не получилос, проверьте данные");
		}
		return "redirect:/opp/add";
	}
	
	
	
	
	@GetMapping("/delete/{id}")
	public String showOppDeleteGet(@PathVariable("id") int id) {
		service.deleteItemById(id);
		return "redirect:/opp/edit";
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


