package com.hydroyura.TechDocsSymbiosis.stp;

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

@Controller
@RequestMapping("/stp")
@SessionAttributes("stpFilter")
public class StpController {
	
	@Autowired
	@Qualifier("StpServiceImpl")
	private StpServiceImpl service;
	
	
	@GetMapping("/index")
	public String showStpIndex() {
		return "/stp/stp_index";
	}
	
	@GetMapping("/list")
	public String showStpListGet() {
		return "/stp/stp_list";
	}
	
	@PostMapping("/list")
	public String showStpListPost() {
		return "redirect:/stp/list";
	}
	
	@GetMapping("/add")
	public String showStpAddGet(Model model) {
		model.addAttribute("stp", new StpEntity());
		return "/stp/stp_add";
	}
	
	@PostMapping("/add")
	public String showStpAddPost(@ModelAttribute("stp") StpEntity stp, RedirectAttributes redirectAttributes) {
		if(service.addItem(stp)) {
			redirectAttributes.addFlashAttribute("msg", "Элемент добавлен успешно");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Добавить элемент не получилось, проверьте вводимые данные");
		}
		return "redirect:/stp/add";
	}
	
	
	@ModelAttribute("stpFilter")
	public StpFilter getFilter() {
		StpFilter stpFilter = new StpFilter();
		stpFilter.addStringElementInMap("STP_TYPE", "ALL_TYPES");
		return stpFilter;
	}
	
	
	@ModelAttribute("sortedStpList")
	public List<StpEntity> getStpListByFilter(@ModelAttribute("stpFilter") StpFilter stpFilter) {
		return service.getItemsBySearchFilter(stpFilter);
	}
	
	@ModelAttribute("stpTypies")
	public List<String> getStpTypies() {
		return service.getStringList();
	}
}
