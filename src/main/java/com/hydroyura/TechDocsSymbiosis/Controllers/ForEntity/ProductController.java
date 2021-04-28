package com.hydroyura.TechDocsSymbiosis.Controllers.ForEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hydroyura.TechDocsSymbiosis.Config.Constants;
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;
import com.hydroyura.TechDocsSymbiosis.Entities.Product;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.OppFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.ProductFilter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseEntityController<Product> {
	
	@Autowired
	public ProductController(@Qualifier("ProductService") BasicServiceForEntity<Product> service) {
		super(service);
	}
	
	@Autowired
	@Qualifier("AsmService")
	private BasicServiceForEntity<Asm> asmService;

	@PostConstruct
	private void init() {
		
		TYPE = Constants.ROW_MAPPER_PRODUCT;
		
		INDEX_GET = "product/product_index";
		LIST_GET = "product/product_list";
		LIST_POST = "redirect:/product/list/";
		EDIT_GET = "product/product_edit";
		DETAIL_GET = "product/product_detail";
		EDIT_ADD_GET = "product/product_add";
		EDIT_ADD_POST = "redirect:/product/edit/add/";
		EDIT_DELETE_GET = "redirect:/product/edit/";
		EDIT_UPDATE_GET = "product/product_update";
		EDIT_UPDATE_POST = "redirect:/product/edit/";
	}
	
	
	@Override
	public String showEditAddGet(Model model) {
		model.addAttribute("item", new Product());
		return EDIT_ADD_GET;
	}

	@Override
	public Filter<Product> getFilter() {
		Filter<Product> filter = new ProductFilter();
		return filter;
	}

	@Override
	public String showListGet(Model model) {
		
		ProductFilter filter;
		filter = (ProductFilter) model.getAttribute("filter");
		if(filter == null) {
			System.out.println(".!.");
			filter = new ProductFilter();
			Map<String, Boolean> status = new HashMap<String, Boolean>();
			status.put("TASK", true);
			status.put("DESIGN", true);
			status.put("NOTE", true);
			model.addAttribute("filter", filter);
		}
		
		
		System.out.println("showListGet() - " + filter);

		
		model.addAttribute("items", service.getFilteredEntities((Filter<Product>) filter));
		
		return LIST_GET;
	}

	@PostMapping("/list")
	public String showListGet(@ModelAttribute("filter") OppFilter filter, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filter", filter);
		return LIST_POST;
	}
	
	
	@ModelAttribute("asmList")
	public List<Asm> getAsmList() {
		return asmService.getFilteredEntities(null);
	}
	
	@Override
	public String showDetailGet(@PathVariable("id") long id, Model model) {
		model.addAttribute("asm", asmService.getEntity(service.getEntity(id).getAsmId()));
		return super.showDetailGet(id, model);
	}


}
