package com.hydroyura.TechDocsSymbiosis.asm;

import java.util.List;

import javax.annotation.PostConstruct;

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

import com.hydroyura.TechDocsSymbiosis.basicclasses.Constants;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ControllerBasic;
import com.hydroyura.TechDocsSymbiosis.basicclasses.ItemsListFilter;
import com.hydroyura.TechDocsSymbiosis.buy.BuyEntity;
import com.hydroyura.TechDocsSymbiosis.buy.BuyService;
import com.hydroyura.TechDocsSymbiosis.data.DataAsm;
import com.hydroyura.TechDocsSymbiosis.opp.OppEntity;
import com.hydroyura.TechDocsSymbiosis.opp.OppService;
import com.hydroyura.TechDocsSymbiosis.oring.OringEntity;
import com.hydroyura.TechDocsSymbiosis.oring.OringService;
import com.hydroyura.TechDocsSymbiosis.spec.SpecEntity;
import com.hydroyura.TechDocsSymbiosis.stp.StpEntity;
import com.hydroyura.TechDocsSymbiosis.stp.StpService;
import com.hydroyura.TechDocsSymbiosis.vzk.VzkEntity;
import com.hydroyura.TechDocsSymbiosis.vzk.VzkService;

@Controller
@RequestMapping("/asm")
public class AsmController extends ControllerBasic<AsmEntity>{
	
	
	@Autowired
	@Qualifier("OppService")
	private OppService oppService;
	
	
	@Autowired
	@Qualifier("OringService")
	private OringService oringService;
	
	@Autowired
	@Qualifier("VzkService")
	private VzkService vzkService;
	
	@Autowired
	@Qualifier("StpService")
	private StpService stpService;
	
	@Autowired
	@Qualifier("BuyService")
	private BuyService buyService;
	
	
	@Autowired
	public AsmController(@Qualifier("AsmService") AsmService service) {
		super(service);
	}
	


	@PostConstruct
	public void init() {
	   INDEX = "asm/asm_index";
	   LIST_GET = "asm/asm_list";
	   LIST_POST = "redirect:asm/list";
	   EDIT_GET = "asm/asm_edit";
	   ADD_GET = "asm/asm_add";
	   ADD_POST = "redirect:asm/add";
	   DELETE_GET = "redirect:asm/edit";
	   EDIT_ITEM_GET = "asm/asm_edit_entity";
	   EDIT_ITEM_POST = "redirect:asm/edit/{id}";	
	}

	@Override
	public List<AsmEntity> getItemsFiltered(@ModelAttribute("filter") ItemsListFilter filter) {
		if(filter.getStringMap().get("NAME") == null && filter.getStringMap().get("NUMBER") == null)
			return service.getItemsByNameAndNumber("", "");
		else return service.getItemsByNameAndNumber(filter.getStringMap().get("NAME"), filter.getStringMap().get("NUMBER")); 
	}

	@Override
	public String showAddGet(Model model) {
		model.addAttribute("item", new AsmEntity());
		return ADD_GET;
	}
	
	@GetMapping("/edit_spec/{id}")
	public String showEditSpecGet(@PathVariable("id") int id, Model model) {
		model.addAttribute("asm", service.getItem(id));
		
		SpecEntity asmSpec = new SpecEntity();

		asmSpec.setOpps(service2.getOppsInAsm(id));
		asmSpec.setOrings(service2.getOringInAsm(id));
		asmSpec.setVzks(service2.getVzkInAsm(id));
		asmSpec.setStps(service2.getStpInAsm(id));
		asmSpec.setBuys(service2.getBuyInAsm(id));
		asmSpec.setAsms(service2.getAsmInAsm(id));
		
		model.addAttribute("asmSpec", asmSpec);
		
		
		DataAsm oppDataAsm = new DataAsm();
		model.addAttribute("oppDataAsm", oppDataAsm);
		
		if(model.getAttribute("oppAddRowFlag") == null) {
			model.addAttribute("oppAddRowFlag", false);
		}
		// -------------------------------------------------
		DataAsm oringDataAsm = new DataAsm();
		model.addAttribute("oringDataAsm", oringDataAsm);
		
		if(model.getAttribute("oringAddRowFlag") == null) {
			model.addAttribute("oringAddRowFlag", false);
		}
		// -------------------------------------------------
		DataAsm vzkDataAsm = new DataAsm();
		model.addAttribute("vzkDataAsm",  vzkDataAsm);
		
		if(model.getAttribute("vzkAddRowFlag") == null) {
			model.addAttribute("vzkAddRowFlag", false);
		}
		// -------------------------------------------------
		DataAsm stpDataAsm = new DataAsm();
		model.addAttribute("stpDataAsm",  stpDataAsm);
		
		if(model.getAttribute("stpAddRowFlag") == null) {
			model.addAttribute("stpAddRowFlag", false);
		}
		// -------------------------------------------------
		DataAsm buyDataAsm = new DataAsm();
		model.addAttribute("buyDataAsm",  buyDataAsm);
		
		if(model.getAttribute("buyAddRowFlag") == null) {
			model.addAttribute("buyAddRowFlag", false);
		}
		// -------------------------------------------------
		DataAsm asmDataAsm = new DataAsm();
		model.addAttribute("asmDataAsm",  asmDataAsm);
		
		if(model.getAttribute("asmAddRowFlag") == null) {
			model.addAttribute("asmAddRowFlag", false);
		}
		// -------------------------------------------------

		return "/asm/asm_edit_spec";
	}
	
	@PostMapping("/edit_spec/{id}")
	public String showEditSpecPost(@PathVariable("id") int id,
			 					   @RequestParam(value = "save_row_opp", required = true, defaultValue = "-1")  int saveRowOpp, 
			 					   @RequestParam(value = "delete_opp", required = true, defaultValue = "-1")  int deleteOppValue, 
			 					   @RequestParam(value = "edit_opp", required = true, defaultValue = "-1")    int editOppValue,
			 					   @RequestParam(value = "add_row_opp", required = true, defaultValue = "-1") int addRowOpp,
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
			 					   @ModelAttribute("oppDataAsm") DataAsm oppDataAsm,
			 					   @ModelAttribute("oringDataAsm") DataAsm oringDataAsm,
			 					   @ModelAttribute("vzkDataAsm") DataAsm vzkDataAsm,
			 					   @ModelAttribute("stpDataAsm") DataAsm stpDataAsm,
			 					   @ModelAttribute("buyDataAsm") DataAsm buyDataAsm,
			 					   @ModelAttribute("asmDataAsm") DataAsm asmDataAsm,
			 					   Model model,
			 					   RedirectAttributes redirectAttributes) {
		
		String str = "redirect:/asm/edit_spec/{id}";
		
		//System.out.println("deleteOppValue = " + deleteOppValue);
		//System.out.println("editOppValue = " + editOppValue);
		//System.out.println("addRowOpp = " + addRowOpp);
		
		if(deleteOppValue != -1) service2.deleteItemByDoubleKey(Constants.TABLE_NAME_ASM_COMP_OPP, deleteOppValue, id);
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
		
		
		//-------------------------------------------------------------------------
		if(deleteOringValue != -1) service2.deleteItemByDoubleKey(Constants.TABLE_NAME_ASM_COMP_ORING, deleteOringValue, id);
		if(editOringValue != -1) str = "redirect:/oring/item/" + editOringValue + "/in-asm/" + id +"";
		if(addRowOring != -1) redirectAttributes.addFlashAttribute("oringAddRowFlag", true);
		
		if(saveRowOring != -1) {
			System.out.println("Нажали кнопку Save");
			redirectAttributes.addFlashAttribute("oringAddRowFlag", false);
			oringDataAsm.setAsmId(id);
			System.out.println("oringDataAsm = " + oringDataAsm);
			service2.addItem(oringDataAsm, Constants.TABLE_NAME_ASM_COMP_ORING);
			System.out.println("Засейвили");
		}
		//-------------------------------------------------------------------------
		if(deleteVzkValue != -1) service2.deleteItemByDoubleKey(Constants.TABLE_NAME_ASM_COMP_VZK, deleteVzkValue, id);
		if(editVzkValue != -1) str = "redirect:/vzk/item/" + editVzkValue + "/in-asm/" + id +"";
		if(addRowVzk != -1) redirectAttributes.addFlashAttribute("vzkAddRowFlag", true);
		
		if(saveRowVzk != -1) {
			System.out.println("Нажали кнопку Save");
			redirectAttributes.addFlashAttribute("vzkAddRowFlag", false);
			vzkDataAsm.setAsmId(id);
			System.out.println("vzkDataAsm = " + vzkDataAsm);
			service2.addItem(vzkDataAsm, Constants.TABLE_NAME_ASM_COMP_VZK);
			System.out.println("Засейвили");
		}

		//-------------------------------------------------------------------------
		if(deleteStpValue != -1) service2.deleteItemByDoubleKey(Constants.TABLE_NAME_ASM_COMP_STP, deleteStpValue, id);
		if(editStpValue != -1) str = "redirect:/stp/item/" + editStpValue + "/in-asm/" + id +"";
		if(addRowStp != -1) redirectAttributes.addFlashAttribute("stpAddRowFlag", true);
		
		if(saveRowStp != -1) {
			System.out.println("Нажали кнопку Save");
			redirectAttributes.addFlashAttribute("stpAddRowFlag", false);
			stpDataAsm.setAsmId(id);
			System.out.println("stpDataAsm = " + stpDataAsm);
			service2.addItem(stpDataAsm, Constants.TABLE_NAME_ASM_COMP_STP);
			System.out.println("Засейвили");
		}
		
		//-------------------------------------------------------------------------
		if(deleteBuyValue != -1) service2.deleteItemByDoubleKey(Constants.TABLE_NAME_ASM_COMP_BUY, deleteBuyValue, id);
		if(editBuyValue != -1) str = "redirect:/buy/item/" + editBuyValue + "/in-asm/" + id +"";
		if(addRowBuy != -1) redirectAttributes.addFlashAttribute("buyAddRowFlag", true);
		
		if(saveRowBuy != -1) {
			System.out.println("Нажали кнопку Save");
			redirectAttributes.addFlashAttribute("buyAddRowFlag", false);
			buyDataAsm.setAsmId(id);
			System.out.println("buyDataAsm = " + buyDataAsm);
			service2.addItem(buyDataAsm, Constants.TABLE_NAME_ASM_COMP_BUY);
			System.out.println("Засейвили");
		}
		
		//-------------------------------------------------------------------------
		if(deleteAsmValue != -1) service2.deleteItemByDoubleKey(Constants.TABLE_NAME_ASM_COMP_ASM, deleteAsmValue, id);
		if(editAsmValue != -1) str = "redirect:/asm/item/" + editAsmValue + "/in-asm/" + id +"";
		if(addRowAsm != -1) redirectAttributes.addFlashAttribute("asmAddRowFlag", true);
		
		if(saveRowAsm != -1) {
			System.out.println("Нажали кнопку Save");
			redirectAttributes.addFlashAttribute("asmAddRowFlag", false);
			asmDataAsm.setAsmId(id);
			System.out.println("asmDataAsm = " + asmDataAsm);
			service2.addItem(asmDataAsm, Constants.TABLE_NAME_ASM_COMP_ASM);
			System.out.println("Засейвили");
		}
		
		
		return str;
		
		// Добавить паттерн Command???
	}
	
	
	
	@ModelAttribute("oppList")
	public List<OppEntity> getOppList() {
		return oppService.getItems();
	}
	
	
	@ModelAttribute("oringList")
	public List<OringEntity> getOringList() {
		return oringService.getItems();
	}
	
	@ModelAttribute("vzkList")
	public List<VzkEntity> getVzkList() {
		return vzkService.getItems();
	}
	
	@ModelAttribute("stpList")
	public List<StpEntity> getStpList() {
		return stpService.getItems();
	}
	
	@ModelAttribute("buyList")
	public List<BuyEntity> getBuyList() {
		return buyService.getItems();
	}
	
	@ModelAttribute("asmList")
	public List<AsmEntity> getAsmList() {
		return service.getItems();
	}

}	


