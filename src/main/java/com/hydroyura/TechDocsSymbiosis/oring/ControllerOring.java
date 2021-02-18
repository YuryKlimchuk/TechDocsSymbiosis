package com.hydroyura.TechDocsSymbiosis.oring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oring")
public class ControllerOring {
	
	@GetMapping("/index")
	public String showOringIndex(Model model) {
		return "/oring/oring_index";
	}
	
	
	@GetMapping("/list")
	public String showOringList(Model model) {
		return "/oring/oring_list";
	}
	
	
}