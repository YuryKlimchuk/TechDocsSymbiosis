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
public class ProductController extends ControllerBasic<Product>{

	
	@Autowired
	public ProductController(@Qualifier("ProductService") ServiceBasic<Product> service) {
		super(service);
	}
	
	
	@PostConstruct
	public void init() {
	   INDEX = "/product/product_index";
	}
	

	@Override
	public String showAddGet(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getItemsFiltered(ItemsListFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
