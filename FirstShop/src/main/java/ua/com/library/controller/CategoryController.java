package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Category;
import ua.com.library.service.CategoryService;
import ua.com.library.validator.ValidationMessages;

@Controller
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/newCategory", method=RequestMethod.GET)
	public String newCategory(Model model){
		model.addAttribute("category", new Category());
		model.addAttribute("categories", DtoUtilMapper.categoriesToCategoriesDTO(categoryService.findAll()));
		
		
		return "views-admin-category";
	}
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute Category category, Model model){
		try{
			categoryService.save(category);
			}catch (Exception e) {
					if(e.getMessage().equals(ValidationMessages.EMPTY_CATEGORY_NAME_FIELD)||
							e.getMessage().equals(ValidationMessages.CATEGORY_ALREADY_EXIST)){
						model.addAttribute("categoryException", e.getMessage());
						model.addAttribute("category", new Category());
						model.addAttribute("categories", DtoUtilMapper.categoriesToCategoriesDTO(categoryService.findAll()));
				}	
				return "views-admin-category";
			}
		
		
		
		return "redirect:/newCategory";
	}
	
	
	@RequestMapping(value="/deleteCategory/{id}", method=RequestMethod.GET)
	
	public String deleteCategory(@PathVariable int id){
		categoryService.delete(id);
		
		return "redirect:/newCategory";
}
	
	
}