package com.hydroyura.TechDocsSymbiosis.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

	
	@GetMapping("hello")
	public String showHelloWorld() {
		return "hello_page";
	}
	
}
