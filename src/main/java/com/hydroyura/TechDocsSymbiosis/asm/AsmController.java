package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;
import com.hydroyura.TechDocsSymbiosis.oring.OringEntity;

@Controller
@RequestMapping("/asm")
public class AsmController {
	
	@Autowired
	private AsmCompServiceImpl service;
	

	
	@GetMapping("/index")
	public String showAsmIndex() {
		return "/asm/asm_index";
	}
	
	@GetMapping("/list")
	public String showAsmListGet() {
		return "/asm/asm_list";
	}
	
	@PostMapping("/list")
	public String showAsmListPost() {
		
		return "redirect:/asm/list";
	}
	
	
	@GetMapping("/add")
	public String showAsmAddGet(Model model) {
		
		if(model.getAttribute("asmComp") == null) {
		
			AsmComposition asmComp = new AsmComposition();
			asmComp.setAsm(new AsmEntity());
			model.addAttribute("asmComp", asmComp);
			
		}
		
		return "/asm/asm_add";
	}
	
	
	@PostMapping("/add")
	public String showAsmAddPost(
			@ModelAttribute("asmComp") AsmComposition asmComp,
			@RequestParam(value="action", required = true) String action, RedirectAttributes redirectAttributes) {
		
		System.out.println(action);
		
		switch (action) {
		case "addOpp":
			asmComp.incOppCount();
			break;
		case "delOpp":
			asmComp.decOppCount();
			break;
		case "addOring":
			asmComp.incOringCount();
			break;
		case "delOring":
			asmComp.decOringCount();
			break;
		case "addInDB":
			service.addItem(asmComp);
			asmComp = new AsmComposition();
			break;
		}	
		
		redirectAttributes.addFlashAttribute("asmComp", asmComp);
		System.out.println("POST " + asmComp);
		return "redirect:/asm/add";
	}
	
	
	
	@ModelAttribute("oppList")
	public List<OppEntity> getOppList() {
		return service.getAllOpp();
	}
	
	@ModelAttribute("oringList")
	public List<OringEntity> getOringList() {
		return service.getAllOring();
	}
	
	@ModelAttribute("listAsm")
	public List<AsmEntity> getItemsBySearchFilter() {
		return service.getAllAsm();
	}
	
	
	
	
	
	
	
	/*
	@Autowired
	private AsmServiceInterface asmService;
	//@Autowired
	//private OppServiceInterface oppService;
	//@Autowired
	//private OringServiceInterface oringService;
	@Autowired
	private StpServiceInterface stpService;
	@Autowired
	private VzkServiceInterface vzkService;
	@Autowired
	private BuyServiceInterface buyService;
	
	
	@GetMapping("/add")
	public String showAddAsmGet(@ModelAttribute("asmCompositionForm") AsmCompositionForm asmCompositionForm) {
		System.out.println("showAddAsmGet");
		return "/asm/asm_add";
	}
	
	
	@PostMapping("/add")
	public String showAddAsmPost(
			@RequestParam(value="action", required = true) String action,  
			@ModelAttribute("asmCompositionForm") AsmCompositionForm asmCompositionForm) {
		
		

		System.out.println("showAddAsmPost");

		switch (action) {
		case "addOpp":
			asmCompositionForm.incCountOpp();
			break;
		case "delOpp":
			asmCompositionForm.decCountOpp();
			break;
			
		case "addOring":
			asmCompositionForm.incCountOring();
			break;
		case "delOring":
			asmCompositionForm.decCountOring();
			break;
			
		case "addStp":
			asmCompositionForm.incCountStp();
			break;
		case "delStp":
			asmCompositionForm.decCountStp();
			break;	
			
		case "addVzk":
			asmCompositionForm.incCountVzk();
			break;
		case "delVzk":
			asmCompositionForm.decCountVzk();
			break;	
		
		case "addBuy":
			asmCompositionForm.incCountBuy();
			break;
		case "delBuy":
			asmCompositionForm.decCountBuy();
			break;
			
		case "addAsm":
			asmCompositionForm.incCountAsm();
			break;
		case "delAsm":
			asmCompositionForm.decCountAsm();
			break;
			
		case "addInDB":
			System.out.println("addInDB");
			System.out.println(asmCompositionForm);
			asmService.addAsmComposition(asmCompositionForm);
			break;
		}
		return "redirect:/asm/add";
	}
	
	@GetMapping("/list")
	public String showAsmListGet(Model model) {
		return "/asm/asm_list";
	}
	
	

	

	
	@GetMapping("/index")
	public String showAsmIndex(Model model) {
		return "/asm/asm_index";
	}
	

	
	
	@ModelAttribute("asmCompositionForm")
	public AsmCompositionForm createAsmCompositionForm() {
		return new AsmCompositionForm();
	}
	
	
	

	
	@ModelAttribute("oringList")
	public List<Oring> getOringList() {
		return oringService.getOringList();
	}
	
	@ModelAttribute("stpList")
	public List<Stp> getStpList() {
		return stpService.getListStp();
	}
	
	@ModelAttribute("vzkList")
	public List<Vzk> getVzkList() {
		return vzkService.getVzkList();
	}
	
	@ModelAttribute("asmList")
	public List<Asm> getAsmList(){
		return asmService.getAsmList();
	}
	
	@ModelAttribute("buyList")
	public List<Buy> getBuyList(){
		return buyService.getAll();
	}

	*/
	
}
