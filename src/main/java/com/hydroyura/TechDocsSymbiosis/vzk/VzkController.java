package com.hydroyura.TechDocsSymbiosis.vzk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/vzk")
public class VzkController {
	
	@Autowired
	private VzkServiceInterface service;
	
	@GetMapping("/index")
	public String showVzkIndex() {
		return "/vzk/vzk_index";
	}
	
	
	@GetMapping("/list")
	public String showVzkList() {
		return "/vzk/vzk_list";
	}
	
	
	@ModelAttribute("vzks")
	public List<Vzk> getVzkList() {
		return service.getVzkList();
	}
	
}
