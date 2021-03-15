package com.hydroyura.TechDocsSymbiosis.basicclasses;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	protected ServiceBasic<T> service;
	
	public ControllerBasic(ServiceBasic<T> service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String showIndex() {
		return INDEX;
	};
	
	@GetMapping("/list")
	public String showListGet() {
		System.out.println("showListGet");
		return LIST_GET;
	}
	
	@PostMapping("/list")
	public String showListPost() {
		System.out.println("showListPost");
		return LIST_POST;
	}
	
	@GetMapping("/edit")
	public String showOEditGet(Model model) {
		return EDIT_GET;
	}
	
	@PostMapping("/edit/{id}")
	public String showEditEntityPost(@PathVariable("id") long id, @ModelAttribute("editableItem") T editableItem) {
		service.updateItem(id, editableItem);
		return EDIT_ITEM_POST;
		// добавить проверку на успешность провеения
	}
	
	@GetMapping("/edit/{id}")
	public String showEditEntityGet(@PathVariable("id") long id, Model model) {
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
	public String showDeleteGet(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
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
