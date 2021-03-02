package com.hydroyura.TechDocsSymbiosis.buy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buy")
public class BuyController {

	@Autowired
	private BuyServiceInterface service;
	
	@GetMapping("/index")
	public String showBuyIndex() {
		return "/buy/buy_index";
	}
	
	
	@GetMapping("/list")
	public String showBuyList(Model model) {
		return "/buy/buy_list";
	}
	
	
	@ModelAttribute("buyies")
	public List<Buy> getAll() {
		return service.getAll();
	}
	
	
	
}
