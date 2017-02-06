package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Size;
import ua.com.library.service.SizeService;
import ua.com.library.validator.ValidationMessages;

@Controller
public class SizeController {

	@Autowired
	private SizeService sizeService;

	@RequestMapping(value = "/newSize", method = RequestMethod.GET)
	public String newSize(Model model) {
		model.addAttribute("size", new Size());
		model.addAttribute("sizes",DtoUtilMapper.sizesToSizesDTO(sizeService.findAll()));
		return "views-admin-size";
	}

	@RequestMapping(value = "/addSize", method = RequestMethod.POST)
	public String addSize(@ModelAttribute Size size, Model model) {
		try {
			sizeService.save(size);
		} catch (Exception e) {
			if (e.getMessage().equals(ValidationMessages.EMPTY_SIZE_NAME_FIELD)
					|| e.getMessage().equals(ValidationMessages.SIZE_ALREADY_EXIST)) {
				model.addAttribute("sizeException", e.getMessage());
				model.addAttribute("size", new Size());
				model.addAttribute("sizes", DtoUtilMapper.sizesToSizesDTO(sizeService.findAll()));
			}
			return "views-admin-size";
		}
		return "redirect:/newSize";
	}

	@RequestMapping(value = "/deleteSize/{id}", method = RequestMethod.GET)
	public String deleteSize(@PathVariable int id) {
		sizeService.delete(id);
		return "redirect:/newSize";
	}
}
