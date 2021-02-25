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
import org.springframework.web.bind.annotation.SessionAttributes;
import com.hydroyura.TechDocsSymbiosis.opp.Opp;
import com.hydroyura.TechDocsSymbiosis.opp.OppServiceInterface;
import com.hydroyura.TechDocsSymbiosis.oring.Oring;
import com.hydroyura.TechDocsSymbiosis.oring.OringServiceInterface;

@Controller
@RequestMapping("/asm")
@SessionAttributes("asmCompositionForm")
public class AsmController {

	private AsmServiceInterface asmService;
	private OppServiceInterface oppService;
	private OringServiceInterface oringService;
	
	@Autowired
	public AsmController(AsmServiceInterface asmService, OppServiceInterface oppService, OringServiceInterface oringService) {
		this.asmService = asmService;
		this.oppService = oppService;
		this.oringService = oringService;
	}


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
	
	@ModelAttribute("oppList")
	public List<Opp> getOppList() {
		return oppService.getOppList();
	}
	
	@ModelAttribute("oringList")
	public List<Oring> getOringList() {
		return oringService.getOringList();
	}
	
	@ModelAttribute("asms")
	public List<Asm> getAsmList(){
		return asmService.getAsmList();
	}
	
	

	
	
}
