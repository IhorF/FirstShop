package ua.com.library.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.CategoryEditor;
import ua.com.library.editor.ColorEditor;
import ua.com.library.editor.CompositionEditor;
import ua.com.library.editor.GenderEditor;
import ua.com.library.editor.SeasonEditor;
import ua.com.library.editor.SizeEditor;
import ua.com.library.entity.Category;
import ua.com.library.entity.Color;
import ua.com.library.entity.Commodity;
import ua.com.library.entity.Composition;
import ua.com.library.entity.Gender;
import ua.com.library.entity.Season;
import ua.com.library.entity.Size;
import ua.com.library.service.CategoryService;
import ua.com.library.service.ColorService;
import ua.com.library.service.CommodityService;
import ua.com.library.service.CompositionService;
import ua.com.library.service.GenderService;
import ua.com.library.service.SeasonService;
import ua.com.library.service.SizeService;
import ua.com.library.validator.ValidationMessages;

@Controller
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CompositionService compositionService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private SeasonService seasonService;
	@Autowired
	private GenderService genderService;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Composition.class, new CompositionEditor(compositionService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeService));
		binder.registerCustomEditor(Season.class, new SeasonEditor(seasonService));
		binder.registerCustomEditor(Gender.class, new GenderEditor(genderService));
	}

	@RequestMapping(value = "/newCommodity", method = RequestMethod.GET)
	public String newCommodity(Model model) {
		model.addAttribute("commoditiesDTOs", DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll()));
		model.addAttribute("compositionDTOs", DtoUtilMapper.compositionsToCompositionsDTO(compositionService.findAll()));
		model.addAttribute("colorDTOs",DtoUtilMapper.colorsToColorsDTO(colorService.findAll()));
		model.addAttribute("categorieDTOs", DtoUtilMapper.categoriesToCategoriesDTO(categoryService.findAll()));
		model.addAttribute("sizeDTOs",DtoUtilMapper.sizesToSizesDTO(sizeService.findAll()));
		model.addAttribute("seasonDTOs",DtoUtilMapper.seasonsToSeasonsDTO(seasonService.findAll()));
		model.addAttribute("genderDTOs",DtoUtilMapper.gendersToGendersDTO(genderService.findAll()));
		model.addAttribute("commodity", new Commodity());
		return "views-admin-commodity";
	}

	@RequestMapping(value = "/addCommodity", method = RequestMethod.POST)
	public String addCommodity(@ModelAttribute Commodity commodity,
			@RequestParam MultipartFile image, Model model) {

		try {
			commodityService.save(commodity);
		} catch (Exception e) {
			if (e.getMessage().equals(ValidationMessages.ARTICUL_ALREADY_EXIST)
					|| e.getMessage().equals(ValidationMessages.PRICE_IS_NULL)
					|| e.getMessage().equals(
							ValidationMessages.EMPTY_ARTICUL_FIELD)) {
				model.addAttribute("commodityArticulException", e.getMessage());
				model.addAttribute("commoditiesDTOs",DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll()));
				model.addAttribute("compositionDTOs", DtoUtilMapper.compositionsToCompositionsDTO(compositionService.findAll()));
				model.addAttribute("colorDTOs",DtoUtilMapper.colorsToColorsDTO(colorService.findAll()));
				model.addAttribute("categorieDTOs", DtoUtilMapper.categoriesToCategoriesDTO(categoryService.findAll()));
				model.addAttribute("sizeDTOs",DtoUtilMapper.sizesToSizesDTO(sizeService.findAll()));
				model.addAttribute("seasonDTOs", DtoUtilMapper.seasonsToSeasonsDTO(seasonService.findAll()));
				model.addAttribute("genderDTOs", DtoUtilMapper.gendersToGendersDTO(genderService.findAll()));
				model.addAttribute("commodity", new Commodity());
			}
			return "views-admin-commodity";
		}
		commodityService.saveImage(commodity.getId(), image);
		return "redirect:/newCommodity";
	}

	@RequestMapping(value = "/deleteCommodity/{id}", method = RequestMethod.GET)
	public String deleteCommodity(@PathVariable String id) {
		commodityService.delete(Integer.parseInt(id));
		return "redirect:/newCommodity";
	}

	@RequestMapping(value = "/deleteCommodityFromListcommodities/{id}", method = RequestMethod.GET)
	public String deleteCommodityFromListcommodities(@PathVariable String id) {
		commodityService.delete(Integer.parseInt(id));
		return "redirect:/listcommodity";
	}

	@RequestMapping(value = "/listcommodity", method = RequestMethod.GET)
	public String listCommodity(Model model) {
		model.addAttribute("commodities", commodityService.findAll());
		return "views-commodity-listcommodity";
	}

	@RequestMapping(value = "/editCommodity/listcommodity", method = RequestMethod.GET)
	public String listCommodity2(Model model) {
		model.addAttribute("commodities", commodityService.findAll());
		return "redirect:/listcommodity";
	}

	@RequestMapping(value = "/saveImageCommodity", method = RequestMethod.POST)
	public String saveImageCommodity(Principal principal, @RequestParam MultipartFile image) {
		commodityService.saveImage(Integer.parseInt(principal.getName()), image);
		return "redirect:/profile";
	}

	@RequestMapping(value = "/editCommodity/{id}", method = RequestMethod.GET)
	public String editCommodity(@PathVariable int id, Model model) {
		model.addAttribute("commodity", commodityService.findOne(id));
		model.addAttribute("commoditiesDTOs", DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll()));
		model.addAttribute("compositionDTOs", DtoUtilMapper.compositionsToCompositionsDTO(compositionService.findAll()));
		model.addAttribute("colorDTOs",DtoUtilMapper.colorsToColorsDTO(colorService.findAll()));
		model.addAttribute("categorieDTOs", DtoUtilMapper.categoriesToCategoriesDTO(categoryService.findAll()));
		model.addAttribute("sizeDTOs",DtoUtilMapper.sizesToSizesDTO(sizeService.findAll()));
		model.addAttribute("seasonDTOs",DtoUtilMapper.seasonsToSeasonsDTO(seasonService.findAll()));
		model.addAttribute("genderDTOs",DtoUtilMapper.gendersToGendersDTO(genderService.findAll()));
		return "views-admin-editCommodity";
	}

	@RequestMapping(value = "/editCommodity/updateCommodity/{id}", method = RequestMethod.POST)
	public String updateCommodity(@PathVariable int id,
			@ModelAttribute Commodity commodity,
			@RequestParam MultipartFile image) throws Exception {
		Commodity updateCommodity = commodityService.findOne(id);
		updateCommodity.setArticul(commodity.getArticul());
		updateCommodity.setPrice(commodity.getPrice());
		updateCommodity.setCategory(commodity.getCategory());
		updateCommodity.setColors(commodity.getColors());
		updateCommodity.setComposition(commodity.getComposition());
		updateCommodity.setGender(commodity.getGender());
		updateCommodity.setPathImage(commodity.getPathImage());
		updateCommodity.setSeason(commodity.getSeason());
		updateCommodity.setSize(commodity.getSize());
		
		commodityService.updateCommodity(updateCommodity);
		commodityService.saveImage(id, image);
		return "redirect:/listcommodity";
	}
}
