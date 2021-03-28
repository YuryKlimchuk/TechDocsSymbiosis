package com.hydroyura.TechDocsSymbiosis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/template")
	public String showTemplate() {
		return "/template2";
	}

}
