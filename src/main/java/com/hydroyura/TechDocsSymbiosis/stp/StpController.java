package com.hydroyura.TechDocsSymbiosis.stp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stp")
public class StpController {
	
	private StpServiceInterface service;
	
	@Autowired
	public StpController(StpServiceInterface service) {
		this.service = service;
	}

	
	
	@GetMapping("/index")
	public String showIndex() {
		
		return "/standart_part/stp_index";
	}
	
	@GetMapping("/list")
	public String showListStpGet() {
		
		return "/standart_part/stp_list";
	}
	
	
	@ModelAttribute("stps")
	public List<Stp> getStps() {
		return service.getListStp();
	}
	
	

}
