package com.hydroyura.TechDocsSymbiosis.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class HelloWorldController {

	
	@GetMapping("/hello")
	public String showHelloWorldGet(@ModelAttribute("user") User user) {
		System.out.println("GET");
		System.out.println(user);
		return "/hello_page";
	}
	
	@PostMapping("/hello")
	public String showHelloWorldPost(@ModelAttribute("user") User user) {
		System.out.println("POST");
		System.out.println(user);
		//status.setComplete();
		return "redirect:/hello";
	}
	
	@ModelAttribute("user") 
	public User getuser() {
		System.out.println("create User");
		return new User();
	}
	
	
}
