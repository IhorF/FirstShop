package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Season;
import ua.com.library.service.SeasonService;
import ua.com.library.validator.ValidationMessages;

@Controller
public class SeasonController {
	@Autowired
	private SeasonService seasonService;

	@RequestMapping(value = "/newSeason", method = RequestMethod.GET)
	public String newSeason(Model model) {
		model.addAttribute("season", new Season());
		model.addAttribute("seasons", DtoUtilMapper.seasonsToSeasonsDTO(seasonService.findAll()));
		return "views-admin-season";
	}

	@RequestMapping(value = "/addSeason", method = RequestMethod.POST)
	public String addSeason(@ModelAttribute Season season, Model model) {
		try {
			seasonService.save(season);
		} catch (Exception e) {
			if (e.getMessage().equals(
					ValidationMessages.EMPTY_SEASON_NAME_FIELD)
					|| e.getMessage().equals(ValidationMessages.SEASON_ALREADY_EXIST)) {
				model.addAttribute("seasonException", e.getMessage());
				model.addAttribute("season", new Season());
				model.addAttribute("seasons", DtoUtilMapper.seasonsToSeasonsDTO(seasonService.findAll()));
			}
			return "views-admin-season";
		}
		return "redirect:/newSeason";
	}

	@RequestMapping(value = "/deleteSeason/{id}", method = RequestMethod.GET)
	public String deleteSeason(@PathVariable int id) {
		seasonService.delete(id);
		return "redirect:/newSeason";
	}
}
