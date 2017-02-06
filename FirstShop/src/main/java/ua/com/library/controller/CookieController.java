package ua.com.library.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.entity.Customer;
import ua.com.library.service.CommodityService;
import ua.com.library.service.CustomerService;

@Controller
public class CookieController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(value="/buyCommodity/{id}", method=RequestMethod.GET)
	public String byCommodity(@RequestParam int  quantity , @PathVariable String id, HttpServletRequest request,HttpServletResponse response){
		customerService.intoBasket(Integer.parseInt(id),quantity, request, response);
		return "redirect:/listcommodity";
		
	}
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basket(HttpServletRequest request, Principal principal, Model model) {		
		Customer customer= customerService.findOne(Integer.parseInt(principal.getName()));	
		model.addAttribute("customer", customer);
		model.addAttribute("commodities", customerService.customerCommoditiesCookie(request));	
		return "views-customer-basket";
	}

	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
	public String getOrder(Principal principal, @PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		customerService.getOrder(principal.getName(), id, request, response);
		return "redirect:/basket";
	}

	@RequestMapping(value = "/deleteFromOrder/{id}", method = RequestMethod.GET)
    public String deleteCookie(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        customerService.deleteCookieFromOrder(id, request, response);
        return "redirect:/basket";
    }	
}
