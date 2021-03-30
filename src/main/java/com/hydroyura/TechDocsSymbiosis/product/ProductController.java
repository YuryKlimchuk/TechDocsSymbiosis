package com.hydroyura.TechDocsSymbiosis.product;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hydroyura.TechDocsSymbiosis.basicclasses.ControllerBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ItemsListFilter;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ServiceBasic;


@Controller
@RequestMapping("/product")
public class ProductController extends ControllerBasic<ProductEntity>{

	
	@Autowired
	public ProductController(@Qualifier("ProductService") ServiceBasic<ProductEntity> service) {
		super(service);
	}
	
	
	@PostConstruct
	public void init() {
	   INDEX = "product/product_index";
	   LIST_GET = "product/product_list";
	   LIST_POST = "redirect:/product/list";
	   EDIT_GET = "product/product_edit";
	   ADD_GET = "product/product_add";
	   ADD_POST = "redirect:product/add";
	   DELETE_GET = "redirect:product/edit";
	   EDIT_ITEM_GET = "product/product_edit_entity";
	   EDIT_ITEM_POST = "redirect:product/edit/{id}";	
	}
	

	@Override
	public String showAddGet(Model model) {
		model.addAttribute("item", new ProductEntity());
		return ADD_GET;
	}

	@Override
	public List<ProductEntity> getItemsFiltered(ItemsListFilter filter) {
		if(filter.getStringMap().get("NAME") == null && filter.getStringMap().get("NUMBER") == null)
			return service.getItemsByNameAndNumber("", "");
		else return service.getItemsByNameAndNumber(filter.getStringMap().get("NAME"), filter.getStringMap().get("NUMBER")); 
	}

}
