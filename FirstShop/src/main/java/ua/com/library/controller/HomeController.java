package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.CommodityEditor;
import ua.com.library.entity.Commodity;
import ua.com.library.service.CommodityService;
import ua.com.library.service.CompositionService;


@Controller
public class HomeController {
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CompositionService compositionService;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
	}
	
	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String home(Model model){
		
		model.addAttribute("commodities", DtoUtilMapper.commoditiesToCommoditiesDTO(commodityService.findAll()));
	//	model.addAttribute("customer",new Customer());
		return "views-base-home";
	}
	
	 @RequestMapping(value = "/home", method = RequestMethod.POST)
	    public String loginprocesing(){
	        return "redirect:/home";
	    }
	 @RequestMapping(value = "/contacts", method = RequestMethod.GET)
	    public String contacts(){
	        return "views-base-contacts";
	    }
	 @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	    public String aboutUs(){
	        return "views-base-aboutUs";
	    }
		
	    @RequestMapping("/loginpage")
	    public String login(){
	    	return "views-base-loginpage";
	    }
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logout() {

			return "redirect:/";

		}
		@RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
		public String logoutPage() {

			return "views-base-logout";
		
}
		@RequestMapping(value = "/editCommodity/logoutPage", method = RequestMethod.GET)
		public String logoutPage2() {

			return "redirect:/logoutPage";
		
}
		}

