package com.hydroyura.TechDocsSymbiosis.Controllers.ForPlanning;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hydroyura.TechDocsSymbiosis.Entities.Product;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.ProductByAsmId;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForPlanning.PlanningService;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForSpecification.SpecificationService;

@Controller
@RequestMapping("/planning")
public class PlanningController {
	
	

	@Autowired
	@Qualifier("ProductService")
	private BasicServiceForEntity<Product> productService;
	
	@Autowired
	@Qualifier("PlanningService")
	private PlanningService planningService; 
	

	
	@GetMapping("/")
	public String showIndexGet() {
		return "planning/planning_index";
	}
	

	@GetMapping("/group-composition/")
	public String showGroupCompositionGet(Model model) {
		
		
		@SuppressWarnings("unchecked")
		Map<Product, Long> products = (HashMap<Product, Long>) model.getAttribute("products");
		

		if(products == null) {
			products = planningService.getProducts();
		}
		
		model.addAttribute("products", products);
		model.addAttribute("itemForAdd", new ProductItemForAdd());
		
		return "planning/planning_composition";
	}
	
	@PostMapping("/group-composition/")
	public String showGroupCompositionPost(@ModelAttribute("itemForAdd") ProductItemForAdd itemForAdd, RedirectAttributes redirectAttributes) {
		
		planningService.getProducts().put(productService.getFilteredEntities(new ProductByAsmId(itemForAdd.getAsmId())).get(0), itemForAdd.getCount());
		
		return "redirect:/planning/group-composition/";
		
	}
	
	
	@GetMapping("/group-composition/detail-specifications/")
	public String showDetailSpecificationGet(Model model) {
		;
		model.addAttribute("specification", planningService.populateSpecificationsMap());
		return "planning/planning_specification_detail";
	}
	
	
	@GetMapping()
	public String showResultGet() {
		
		return "planning/planning_result";
	}
	
	
	@ModelAttribute("items")
	public List<Product> getItems() {
		return productService.getFilteredEntities(null);
	}
	
	@ModelAttribute("userName")
	public String getUserName(Principal principal) {
		return principal.getName();
	}

	
	
}
