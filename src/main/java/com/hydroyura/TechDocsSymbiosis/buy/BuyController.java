package com.hydroyura.TechDocsSymbiosis.buy;

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

import com.hydroyura.TechDocsSymbiosis.abstractmodel.SearchFilter;

@Controller
@RequestMapping("/buy")
@SessionAttributes("buyFilter")
public class BuyController {

	
	@Autowired
	@Qualifier("BuyServiceImpl")
	private BuyServiceImpl service;
	
	
	@GetMapping("/index")
	public String showBuyIndex() {
		return "/buy/buy_index";
	}
	
	@GetMapping("/list")
	public String showBuyListGet() {
		return "/buy/buy_list";
	}
	
	@PostMapping("/list")
	public String showBuyListPost() {
		return "redirect:/buy/list";
	}
	
	@GetMapping("/add")
	public String showBuyAddListGet(Model model) {
		model.addAttribute("buy", new BuyEntity());
		return "/buy/buy_add";
	}
	
	@PostMapping("/add")
	public String showBuyAddListPost(@ModelAttribute("buy") BuyEntity buy, 
			RedirectAttributes redirectAttributes) {
		
		if(service.addItem(buy)) {
			redirectAttributes.addFlashAttribute("msg", "Элемент добавлен успешно");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Добавить элемент не получилось, проверьте вводимые данные");
		}
		
		return "redirect:/buy/add";
	}
	
	
	
	
	
	@ModelAttribute("buyFilter")
	public SearchFilter getFilter() {
		SearchFilter buyFilter = new BuyFilter();
		buyFilter.addStringElementInMap("BUY_TYPE", "ALL_TYPES");
		return buyFilter;
	}
	
	@ModelAttribute("sortedBuyList")
	public List<BuyEntity> getBuyListByFilter(@ModelAttribute("buyFilter") SearchFilter buyFilter) {
		return service.getItemsBySearchFilter(buyFilter);
	}

	@ModelAttribute("buyTypies")
	public List<String> getBuyTypies() {
		return service.getStringList();
	}
	
	
}
