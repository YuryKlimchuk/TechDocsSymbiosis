package com.hydroyura.TechDocsSymbiosis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hydroyura.TechDocsSymbiosis.Entities.Opp;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.OppService;

@RestController
public class TestRestController {

	private Opp opp = new Opp();

	@Autowired
	private OppService service;
	
	@GetMapping("/test")
	public @ResponseBody Opp testShow() {
		return opp;
	}
	
	@GetMapping("/test2")
	public @ResponseBody List<Opp> testShow2() {
		return service.getFilteredEntities(null);
	}
	
	
	@GetMapping("/testmap")
	public @ResponseBody String testmap() {
		
		Vzk vzk1 = new Vzk();
		Vzk vzk2 = new Vzk();
		
		vzk1.setId(15);
		vzk2.setId(15);
		
		Map<Vzk, String> map = new HashMap<Vzk, String>();
		map.put(vzk1, "Hello");
		System.out.println(map.containsKey(vzk2));
		
		
		return "hellow";
	}
}
