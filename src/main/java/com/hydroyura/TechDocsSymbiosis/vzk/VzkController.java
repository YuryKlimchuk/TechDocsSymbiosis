package com.hydroyura.TechDocsSymbiosis.vzk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hydroyura.TechDocsSymbiosis.abstractmodel.ServiceInterface;

@Controller
@RequestMapping("/vzk")
@SessionAttributes("vzkFilter")
public class VzkController {

	
	@Autowired
	@Qualifier("VzkServiceImpl")
	private ServiceInterface<VzkEntity> service;
	
	@GetMapping("/index")
	public String showIndex() {
		return "/vzk/vzk_index";
	}
	
	@GetMapping("/list")
	public String showListGet() {
		return "/vzk/vzk_list";	
	}
	
	@PostMapping("/list")
	public String showListPost() {
		return "redirect:/vzk/list";	
	}
	
	@GetMapping("/add")
	public String showAddGet(Model model) {
		model.addAttribute("entity", new VzkEntity());
		return "/vzk/vzk_add";
	}
	
	@PostMapping("/add")
	public String showAddPost(@ModelAttribute("entity") VzkEntity entity, RedirectAttributes redirectAttributes) {
		if(service.addItem(entity)) {
			redirectAttributes.addFlashAttribute("msg", "Элемент добавлен успешно");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Добавить элемент не получилось, проверьте вводимые данные");
		}
		return "redirect:/vzk/add";
	}
	
	@ModelAttribute("vzkFilter")
	public VzkFilter getFilter() {
		VzkFilter vzkFilter = new VzkFilter();
		vzkFilter.addStringElementInMap("VZK_TYPE", "ALL_TYPES");
		return vzkFilter;
	}
	
	@ModelAttribute("sortedVzkList")
	public List<VzkEntity> getVzkListByFilter(@ModelAttribute("vzkFilter") VzkFilter vzkFilter) {
		return service.getItemsBySearchFilter(vzkFilter);
	}
	
	@ModelAttribute("vzkTypies")
	public List<String> getVzkTypies() {
		return service.getStringList();
	}
	
}
