package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Composition;
import ua.com.library.service.CommodityService;
import ua.com.library.service.CompositionService;
import ua.com.library.validator.ValidationMessages;

@Controller
public class CompositionController {

	@Autowired
	private CompositionService compositionService;
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(value="/newComposition", method=RequestMethod.GET)
	public String newComposition(Model model){
		model.addAttribute("compositions", DtoUtilMapper.compositionsToCompositionsDTO(compositionService.findAll()));
		return "views-admin-composition";
	}
	
	@RequestMapping(value="/addComposition", method=RequestMethod.POST)
	public String addComposition(@RequestParam String bavovna, @RequestParam String poliamid,@RequestParam String elastan,Model model){
		
		try{
			compositionService.save(new Composition(bavovna, poliamid, elastan));
			}catch (Exception e) {
				
					if(e.getMessage().equals(ValidationMessages.EMPTY_FIELD)||
							e.getMessage().equals(ValidationMessages.COMPOSITION_VALUE_TOO_LARGE_OR_TOO_SMALL)	||
							e.getMessage().equals(ValidationMessages.COMPOSITION_ALREADY_EXIST)){
						model.addAttribute("compositionException", e.getMessage());
						model.addAttribute("compositions", DtoUtilMapper.compositionsToCompositionsDTO(compositionService.findAll()));
				}	
				return "views-admin-composition";
			}
		return "redirect:/newComposition";
	}
	
	@RequestMapping(value="/delComposition/{id}", method=RequestMethod.GET)
	public String newComposition(@PathVariable int id){
		compositionService.delete(id);
		return "redirect:/newComposition";
	}
	@RequestMapping(value="/deleteCommodityFromComposition/{idCommodity}")
	public String deleteCommodityFromComposition(@PathVariable String idCommodity){
		compositionService.deleteCommodityFromComposition(idCommodity);
		return "redirect:/newComposition";
	}

}
