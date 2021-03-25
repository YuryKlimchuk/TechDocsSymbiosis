package com.hydroyura.TechDocsSymbiosis.basicclasses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hydroyura.TechDocsSymbiosis.data.DataAsm;
import com.hydroyura.TechDocsSymbiosis.data.DataService;

@SessionAttributes("filter")
public abstract class ControllerBasic<T> {

	protected String INDEX;
	protected String LIST_GET;
	protected String LIST_POST;
	protected String EDIT_GET;
	protected String ADD_GET;
	protected String ADD_POST;
	protected String DELETE_GET;
	protected String EDIT_ITEM_GET;
	protected String EDIT_ITEM_POST;
	protected String ITEM_IN_ASM_POST;
	protected String ITEM_IN_ASM_GET;
	protected ServiceBasic<T> service;
	
	@Autowired
	@Qualifier("DataService")
	protected DataService service2;
	
	public ControllerBasic(ServiceBasic<T> service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String showIndex() {
		return INDEX;
	};
	
	@GetMapping("/item/{id}/in-asm/{asmid}")
	public String showItemInAsm(
							@PathVariable("id") int id,
							@PathVariable("asmid") int asmid,
							Model model) {
		
		System.out.println("showItemInAsm - GET");
		model.addAttribute("asmid", asmid);
		model.addAttribute("id", id);
		
		DataAsm dataAsm = service.getItemInnerJoinByDoubleKey(id, asmid);
		model.addAttribute("dataAsm", dataAsm);
		
		return ITEM_IN_ASM_GET; 
	}
	
	@PostMapping("/item/{id}/in-asm/{asmid}")
	public String showItemInAsmPost(
			@PathVariable("id") int id,
			@PathVariable("asmid") int asmid,
			@ModelAttribute("dataAsm") DataAsm dataAsm) {
		
		System.out.println("showItemInAsm - POST 1 ");
		service.updateItemByDoubleKey(id, asmid, dataAsm);
		System.out.println("showItemInAsm - POST 2 ");
		
		return ITEM_IN_ASM_POST;
	}
	
	@GetMapping("/list")
	public String showListGet() {
		return LIST_GET;
	}
	
	@PostMapping("/list")
	public String showListPost() {
		return LIST_POST;
	}
	
	@GetMapping("/edit")
	public String showOEditGet(Model model) {
		return EDIT_GET;
	}
	
	@PostMapping("/edit/{id}")
	public String showEditEntityPost(@PathVariable("id") int id, @ModelAttribute("editableItem") T editableItem) {
		service.updateItem(id, editableItem);
		return EDIT_ITEM_POST;
		// добавить проверку на успешность провеения
	}
	
	@GetMapping("/edit/{id}")
	public String showEditEntityGet(@PathVariable("id") int id, Model model) {
		model.addAttribute("editableItem", service.getItem(id));
		return EDIT_ITEM_GET;
	}

	@GetMapping("/add")
	public abstract String showAddGet(Model model);
	
	@PostMapping("/add")
	public String showAddPost(T entity, RedirectAttributes redirectAttributes) {
		if(service.addItem(entity) != -1) {
			redirectAttributes.addFlashAttribute("msg", "Элемент успешно добавлен");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Элемент не добавлен, проверте вводимые данные");
		}
		return ADD_POST;
	}

	@GetMapping("/delete/{id}")
	public String showDeleteGet(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		if(service.deleteItem(id) != -1) {
			redirectAttributes.addFlashAttribute("msg", "Элемент успешно удален");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Элемент не удален, возможно он содержиться в связанных таблицах");
		}
		
		return DELETE_GET;
	}
	
	@ModelAttribute("itemsFiltered")
	public abstract List<T> getItemsFiltered(ItemsListFilter filter);
	
	@ModelAttribute("filter")
	public ItemsListFilter getFilter() {
		return new ItemsListFilter();
	}

	@ModelAttribute("items")
	public List<T> getItems() {
		return service.getItems();
	}
	
	
	
}
