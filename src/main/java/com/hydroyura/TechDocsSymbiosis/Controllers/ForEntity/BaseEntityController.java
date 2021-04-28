package com.hydroyura.TechDocsSymbiosis.Controllers.ForEntity;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hydroyura.TechDocsSymbiosis.ServiceLayer.Filters.Filter;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForEntity.BasicServiceForEntity;

@SessionAttributes("userName")
public abstract class BaseEntityController<T> {
	
	protected String INDEX_GET;
	protected String LIST_GET;
	protected String LIST_POST;
	protected String EDIT_GET;
	protected String EDIT_ADD_GET;
	protected String EDIT_ADD_POST;
	protected String EDIT_DELETE_GET;
	protected String DETAIL_GET;
	protected String TYPE;
	protected String EDIT_UPDATE_GET;
	protected String EDIT_UPDATE_POST;
	protected BasicServiceForEntity<T> service;
	
	public BaseEntityController(BasicServiceForEntity<T> service) {
		this.service = service;
	}
	
	
	@GetMapping("/")
	public String showIndexGet() {
		return INDEX_GET;
	};
	
	@GetMapping("/list/")
	public abstract String showListGet(Model model);
	
	@GetMapping("/list/{id}/")
	public String showDetailGet(@PathVariable("id") long id, Model model) {
		model.addAttribute("item", service.getEntity(id));
		model.addAttribute("asmList", service.getSpecificationRowsByEntityId(id));
		return DETAIL_GET;
	};
	
	@GetMapping("/edit/")
	public String showEditGet(Model model) {
		model.addAttribute("items", service.getFilteredEntities(null));
		return EDIT_GET;
	};
	
	
	@GetMapping("/edit/add/")
	public abstract String showEditAddGet(Model model);

	
	@PostMapping("/edit/add/")
	public String showAddPost(T entity, RedirectAttributes redirectAttributes) {
		if(service.addEntity(entity) != -1) {
			redirectAttributes.addFlashAttribute("msg", "Элемент успешно добавлен");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Элемент не добавлен, проверте вводимые данные");
		}
		return EDIT_ADD_POST;
	}
	
	@GetMapping("edit/delete/{id}/")
	public String showDeleteGet(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		if(service.deleteEntity(id) != -1) {
			redirectAttributes.addFlashAttribute("msg", "Элемент успешно удален");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Элемент не удален, возможно он содержиться в связанных таблицах");
		}
		
		return EDIT_DELETE_GET;
	}
	
	@GetMapping("/edit/{id}/")
	public String showEditEntityGet(@PathVariable("id") long id, Model model) {
		model.addAttribute("editableItem", service.getEntity(id));
		return EDIT_UPDATE_GET;
	}
	
	
	@PostMapping("/edit/{id}/")
	public String showEditEntityPost(@PathVariable("id") long id, @ModelAttribute("editableItem") T editableItem) {
		service.update(id, editableItem);
		return EDIT_UPDATE_POST;
		// добавить проверку на успешность провеения
	}

	
	@ModelAttribute("userName")
	public String getUserName(Principal principal) {
		return principal.getName();
	}
	
	@ModelAttribute("filter")
	public abstract Filter<T> getFilter();
	

}
