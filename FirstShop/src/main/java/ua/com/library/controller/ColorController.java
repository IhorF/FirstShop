package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Color;
import ua.com.library.service.ColorService;
import ua.com.library.validator.ValidationMessages;

@Controller
public class ColorController {
	@Autowired
	private ColorService colorService;

	@RequestMapping(value = "/newColor", method = RequestMethod.GET)
	public String newColor(Model model) {
		model.addAttribute("color", new Color());
		model.addAttribute("colors", DtoUtilMapper.colorsToColorsDTO(colorService.findAll()));
		return "views-admin-color";
	}

	@RequestMapping(value = "/addColor", method = RequestMethod.POST)
	public String addColor(@ModelAttribute Color color, Model model) {
		try {
			colorService.save(color);
		} catch (Exception e) {
			if (e.getMessage()
					.equals(ValidationMessages.EMPTY_COLOR_NAME_FIELD)
					|| e.getMessage().equals(
							ValidationMessages.COLOR_ALREADY_EXIST)) {
				model.addAttribute("colorException", e.getMessage());
				model.addAttribute("color", new Color());
				model.addAttribute("colors",DtoUtilMapper.colorsToColorsDTO(colorService.findAll()));
			}
			return "views-admin-color";
		}
		return "redirect:/newColor";
	}

	@RequestMapping(value = "/deleteColor/{id}", method = RequestMethod.GET)
	public String deleteColor(@PathVariable int id) {
		colorService.delete(id);
		return "redirect:/newColor";
	}
}
