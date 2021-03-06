package com.hydroyura.TechDocsSymbiosis.oring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/oring")
@SessionAttributes("oringListFilter")
public class OringController {
	
	@Autowired
	private OringServiceImpl service;

	@GetMapping("/index")
	public String showOringIndex(Model model) {
		return "/oring/oring_index";
	}
	
	@GetMapping("/add")
	public String showOringAddGet(Model model) {		
		model.addAttribute("oring", new OringEntity());
		return "/oring/oring_add";
	}
	
	@PostMapping("/add")
	public String showOppAddPost(@ModelAttribute("oring") OringEntity oring, RedirectAttributes redirectAttributes) {
		if(service.addItem(oring)) {
			redirectAttributes.addFlashAttribute("msg", "Элемент добавлен успешно");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Добавить элемент не получилос, проверьте данные");
		}
		return "redirect:/oring/add";
	}
	
	@GetMapping("/list")
	public String showOringListGet() {
		return "/oring/oring_list";
	}
	
	@PostMapping("/list")
	public String showOringListPost() {
		return "redirect:/oring/list";
	}
	
	@GetMapping("/delete/{id}")
	public String showOringDeleteGet(@PathVariable("id") int id) {
		service.deleteItemById(id);
		return "redirect:/oring/edit";
	}
	
	@GetMapping("/edit")
	public String showOringEditGet() {
		return "/oring/oring_edit";
	}
	
	@GetMapping("/edit/{id}")
	public String showOringEditEntityGet(@PathVariable("id") int id, Model model) {
		model.addAttribute("editableOring", service.getItemById(id));
		return "/oring/oring_edit_entity";
	}
	
	@PostMapping("/edit/{id}")
	public String showOringEditEntityPost(@PathVariable("id") int id, 
										@ModelAttribute("editableOpp") OringEntity editableOring) {
		service.changeItem(id, editableOring);
		return "redirect:/oring/edit/{id}";
	}
	
	@ModelAttribute("oringListFilter")
	public OringFilter getFilter() {		
		OringFilter oringFilter = new OringFilter();
		oringFilter.addFloatElementInMap("min", service.getMinInnerDiamter());
		oringFilter.addFloatElementInMap("max", service.getMaxInnerDiamter());
		for (Float value: service.getFloatList()) {
			oringFilter.addBooleanElementInMap(value, false);
		}
		return oringFilter;	
	}
	
	@ModelAttribute("listOring")
	public List<OringEntity> getItemsBySearchFilter(@ModelAttribute("oringListFilter") OringFilter oringListFilter) {
		return service.getItemsBySearchFilter(oringListFilter);
	}
	
	
	
	
}