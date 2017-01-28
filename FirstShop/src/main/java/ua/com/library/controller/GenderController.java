package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Gender;
import ua.com.library.service.GenderService;
import ua.com.library.validator.ValidationMessages;

@Controller
public class GenderController {
		@Autowired
	private GenderService genderService;
		
	@RequestMapping(value="/newGender", method=RequestMethod.GET)
	public String newGender(Model model){
		model.addAttribute("gender", new Gender());
		model.addAttribute("genders",DtoUtilMapper.gendersToGendersDTO( genderService.findAll()));
		
		
		return "views-admin-gender";
	}
	
	@RequestMapping(value="/addGender", method=RequestMethod.POST)
	public String addGender(@ModelAttribute Gender gender, Model model){
		try{
			genderService.save(gender);
			}catch (Exception e) {
					if(e.getMessage().equals(ValidationMessages.EMPTY_GENDER_NAME_FIELD)||
							e.getMessage().equals(ValidationMessages.GENDER_ALREADY_EXIST)){
						model.addAttribute("genderException", e.getMessage());
						model.addAttribute("gender", new Gender());
						model.addAttribute("genders",DtoUtilMapper.gendersToGendersDTO( genderService.findAll()));
				}	
					return "views-admin-gender";
			}
		
		
		
		return "redirect:/newGender";
	}
	

	@RequestMapping(value="/deleteGender/{id}", method=RequestMethod.GET)
	
	public String deleteGender(@PathVariable int id){
	genderService.delete(id);
		
		return "redirect:/newGender";
}
}
