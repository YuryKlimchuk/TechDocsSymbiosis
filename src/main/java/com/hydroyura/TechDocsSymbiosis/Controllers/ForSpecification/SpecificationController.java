package com.hydroyura.TechDocsSymbiosis.Controllers.ForSpecification;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hydroyura.TechDocsSymbiosis.DAOLayer.ForSpecRow.CompositeKeySpecRow;
import com.hydroyura.TechDocsSymbiosis.Entities.Asm;
import com.hydroyura.TechDocsSymbiosis.Entities.Buy;
import com.hydroyura.TechDocsSymbiosis.Entities.Opp;
import com.hydroyura.TechDocsSymbiosis.Entities.Oring;
import com.hydroyura.TechDocsSymbiosis.Entities.SpecificationRow;
import com.hydroyura.TechDocsSymbiosis.Entities.Stp;
import com.hydroyura.TechDocsSymbiosis.Entities.Vzk;
import com.hydroyura.TechDocsSymbiosis.ServiceLayer.ForSpecification.SpecificationService;

@Controller
@RequestMapping("/specification")
public class SpecificationController {
	
	@Autowired
	@Qualifier("SpecificationService")
	private SpecificationService specificationService;
	
	
	@GetMapping("/{id}/")
	public String showSpecificationGet(@PathVariable("id") long id, Model model) {
		model.addAttribute("specification", specificationService.getSpecification(id));
		return "specification/specification";
	}
	
	@GetMapping("/detail/{id}/")
	public String showSpecificationDetailGet(@PathVariable("id") long id, Model model) {
		model.addAttribute("specification", specificationService.getDetailSpecification(id));
		return "specification/specification_detail";
	}
	
	@GetMapping("/edit/{id}/")
	public String showSpecificationEditGet(@PathVariable("id") long id, Model model) {
		model.addAttribute("specification", specificationService.getSpecification(id));
		// -------------------------------------------------------------------------------
		SpecificationRow oppSpec = new SpecificationRow();
		model.addAttribute("oppSpec", oppSpec);
		if(model.getAttribute("oppSpecFlag") == null) 
			model.addAttribute("oppSpecFlag", false);
		// -------------------------------------------------
		SpecificationRow asmSpec = new SpecificationRow();
		model.addAttribute("asmSpec", asmSpec);
		if(model.getAttribute("asmSpecFlag") == null) 
			model.addAttribute("asmSpecFlag", false);
		// -------------------------------------------------
		SpecificationRow stpSpec = new SpecificationRow();
		model.addAttribute("stpSpec", stpSpec);
		if(model.getAttribute("stpSpecFlag") == null) 
			model.addAttribute("stpSpecFlag", false);
		// -------------------------------------------------
		SpecificationRow buySpec = new SpecificationRow();
		model.addAttribute("buySpec", buySpec);
		if(model.getAttribute("buySpecFlag") == null) 
			model.addAttribute("buySpecFlag", false);
		// -------------------------------------------------
		SpecificationRow oringSpec = new SpecificationRow();
		model.addAttribute("oringSpec", oringSpec);
		if(model.getAttribute("oringSpecFlag") == null) 
			model.addAttribute("oringSpecFlag", false);
		// -------------------------------------------------
		SpecificationRow vzkSpec = new SpecificationRow();
		model.addAttribute("vzkSpec", vzkSpec);
		if(model.getAttribute("vzkSpecFlag") == null) 
			model.addAttribute("vzkSpecFlag", false);
		// -------------------------------------------------------------------------------
		return "specification/specification_edit";
	}
	
	@PostMapping("/edit/{id}/")
	public String showSpecificationEditPost(
								   @PathVariable("id") int id,
			 					   @RequestParam(value = "save_row_opp", required = true, defaultValue = "-1")  int saveRowOpp, 
			 					   @RequestParam(value = "delete_opp", 	 required = true, defaultValue = "-1")  int deleteOppValue, 
			 					   @RequestParam(value = "edit_opp",     required = true, defaultValue = "-1")  int editOppValue,
			 					   @RequestParam(value = "add_row_opp",  required = true, defaultValue = "-1")  int addRowOpp,
			 					   //---------------------------------------------------------------------------------------------
			 					   @RequestParam(value = "save_row_oring", required = true, defaultValue = "-1")  int saveRowOring, 
			 					   @RequestParam(value = "delete_oring", required = true, defaultValue = "-1")  int deleteOringValue, 
			 					   @RequestParam(value = "edit_oring", required = true, defaultValue = "-1")    int editOringValue,
			 					   @RequestParam(value = "add_row_oring", required = true, defaultValue = "-1") int addRowOring,
			 					   //---------------------------------------------------------------------------------------------
			 					   @RequestParam(value = "save_row_vzk", required = true, defaultValue = "-1")  int saveRowVzk, 
			 					   @RequestParam(value = "delete_vzk", required = true, defaultValue = "-1")  int deleteVzkValue, 
			 					   @RequestParam(value = "edit_vzk", required = true, defaultValue = "-1")    int editVzkValue,
			 					   @RequestParam(value = "add_row_vzk", required = true, defaultValue = "-1") int addRowVzk,
			 					   //---------------------------------------------------------------------------------------------
			 					   @RequestParam(value = "save_row_stp", required = true, defaultValue = "-1")  int saveRowStp, 
			 					   @RequestParam(value = "delete_stp", required = true, defaultValue = "-1")  int deleteStpValue, 
			 					   @RequestParam(value = "edit_stp", required = true, defaultValue = "-1")    int editStpValue,
			 					   @RequestParam(value = "add_row_stp", required = true, defaultValue = "-1") int addRowStp,
			 					   //---------------------------------------------------------------------------------------------
			 					   @RequestParam(value = "save_row_buy", required = true, defaultValue = "-1")  int saveRowBuy, 
			 					   @RequestParam(value = "delete_buy", required = true, defaultValue = "-1")  int deleteBuyValue, 
			 					   @RequestParam(value = "edit_buy", required = true, defaultValue = "-1")    int editBuyValue,
			 					   @RequestParam(value = "add_row_buy", required = true, defaultValue = "-1") int addRowBuy,
			 					   //---------------------------------------------------------------------------------------------
			 					   @RequestParam(value = "save_row_asm", required = true, defaultValue = "-1")  int saveRowAsm, 
			 					   @RequestParam(value = "delete_asm", required = true, defaultValue = "-1")  int deleteAsmValue, 
			 					   @RequestParam(value = "edit_asm", required = true, defaultValue = "-1")    int editAsmValue,
			 					   @RequestParam(value = "add_row_asm", required = true, defaultValue = "-1") int addRowAsm,
			 					   //---------------------------------------------------------------------------------------------
			 					   @ModelAttribute("oppSpec")   SpecificationRow oppSpec,
			 					   @ModelAttribute("oringSpec") SpecificationRow oringSpec,
			 					   @ModelAttribute("vzkSpec")   SpecificationRow vzkSpec,
			 					   @ModelAttribute("stpSpec")   SpecificationRow stpSpec,
			 					   @ModelAttribute("buySpec")   SpecificationRow buySpec,
			 					   @ModelAttribute("asmSpec")   SpecificationRow asmSpec,
			 					   Model model,
			 					   RedirectAttributes redirectAttributes) {
		
		String str = "redirect:/specification/edit/{id}/";
		
		//---------------------------------------------------------------------------------------------------------------------------
		if(deleteOppValue != -1) specificationService.deleteRowFromSpecification(new CompositeKeySpecRow(deleteOppValue, id, "opp"));
		if(deleteAsmValue != -1) specificationService.deleteRowFromSpecification(new CompositeKeySpecRow(deleteAsmValue, id, "asm"));
		if(deleteOringValue != -1) specificationService.deleteRowFromSpecification(new CompositeKeySpecRow(deleteOringValue, id, "oring"));
		if(deleteStpValue != -1) specificationService.deleteRowFromSpecification(new CompositeKeySpecRow(deleteStpValue, id, "stp"));
		if(deleteVzkValue != -1) specificationService.deleteRowFromSpecification(new CompositeKeySpecRow(deleteVzkValue, id, "vzk"));
		if(deleteBuyValue != -1) specificationService.deleteRowFromSpecification(new CompositeKeySpecRow(deleteBuyValue, id, "buy"));
		//---------------------------------------------------------------------------------------------------------------------------
		if(addRowOpp != -1) redirectAttributes.addFlashAttribute("oppSpecFlag", true);
		if(addRowOring != -1) redirectAttributes.addFlashAttribute("oringSpecFlag", true);
		if(addRowAsm != -1) redirectAttributes.addFlashAttribute("asmSpecFlag", true);
		if(addRowVzk != -1) redirectAttributes.addFlashAttribute("vzkSpecFlag", true);
		if(addRowBuy != -1) redirectAttributes.addFlashAttribute("buySpecFlag", true);
		if(addRowStp != -1) redirectAttributes.addFlashAttribute("stpSpecFlag", true);
		//---------------------------------------------------------------------------------------------------------------------------
		if(saveRowOpp != -1) {
			redirectAttributes.addFlashAttribute("oppSpecFlag", false);
			oppSpec.setAsmId(id);
			oppSpec.setChange(-1);
			oppSpec.setRowType("opp");
			specificationService.addRowInSpecification(oppSpec);
		}
		if(saveRowAsm != -1) {
			redirectAttributes.addFlashAttribute("asmSpecFlag", false);
			asmSpec.setAsmId(id);
			asmSpec.setChange(-1);
			asmSpec.setRowType("asm");
			specificationService.addRowInSpecification(asmSpec);
		}
		if(saveRowOring != -1) {
			redirectAttributes.addFlashAttribute("oringSpecFlag", false);
			oringSpec.setAsmId(id);
			oringSpec.setChange(-1);
			oringSpec.setRowType("oring");
			specificationService.addRowInSpecification(oringSpec);
		}
		if(saveRowStp != -1) {
			redirectAttributes.addFlashAttribute("stpSpecFlag", false);
			stpSpec.setAsmId(id);
			stpSpec.setChange(-1);
			stpSpec.setRowType("stp");
			specificationService.addRowInSpecification(stpSpec);
		}
		if(saveRowVzk != -1) {
			redirectAttributes.addFlashAttribute("vzkSpecFlag", false);
			vzkSpec.setAsmId(id);
			vzkSpec.setChange(-1);
			vzkSpec.setRowType("vzk");
			specificationService.addRowInSpecification(vzkSpec);
		}
		if(saveRowBuy != -1) {
			redirectAttributes.addFlashAttribute("buySpecFlag", false);
			buySpec.setAsmId(id);
			buySpec.setChange(-1);
			buySpec.setRowType("buy");
			specificationService.addRowInSpecification(buySpec);
		}
		
		
		/*
		if(deleteOppValue != -1) service2.deleteItemByDoubleKey(Constants.TABLE_NAME_SPECIFICATION_ROWS, deleteOppValue, id);
		if(editOppValue != -1) str = "redirect:/opp/item/" + editOppValue + "/in-asm/" + id +"";
		if(addRowOpp != -1) redirectAttributes.addFlashAttribute("oppAddRowFlag", true);
		
		if(saveRowOpp != -1) {
			System.out.println("Нажали кнопку Save");
			redirectAttributes.addFlashAttribute("oppAddRowFlag", false);
			oppDataAsm.setAsmId(id);
			System.out.println("oppDataAsm = " + oppDataAsm);
			service2.addItem(oppDataAsm, Constants.TABLE_NAME_ASM_COMP_OPP);
			System.out.println("Засейвили");
		}
		
		/*
*/

		return str;
		
		// Добавить паттерн Command???
	}
	
	
	
	
	
	
	@ModelAttribute("oppList")
	public List<Opp> getOppList() {
		return specificationService.getOppList();
	}
	
	@ModelAttribute("asmList")
	public List<Asm> getAsmList() {
		return specificationService.getAsmList();
	}
	
	@ModelAttribute("stpList")
	public List<Stp> getStpList() {
		return specificationService.getStpList();
	}
	
	@ModelAttribute("vzkList")
	public List<Vzk> getVzkList() {
		return specificationService.getVzkList();
	}
	
	@ModelAttribute("oringList")
	public List<Oring> getOringList() {
		return specificationService.getOringList();
	}
	
	@ModelAttribute("buyList")
	public List<Buy> getBuyList() {
		return specificationService.getBuyList();
	}
	
	@ModelAttribute("userName")
	public String getUserName(Principal principal) {
		return principal.getName();
	}

}
