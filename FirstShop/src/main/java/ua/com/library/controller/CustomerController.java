package ua.com.library.controller;


import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Customer;
import ua.com.library.service.CustomerService;
import ua.com.library.service.MailSenderService;
import ua.com.library.validator.ValidationMessages;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private MailSenderService mailSenderService;
	
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String newCustomer(Model model){
		model.addAttribute("customerDTOs", DtoUtilMapper.customerToCustomersDTOs( customerService.findAll()));
		model.addAttribute("customer", new Customer());
		return "views-customer-registration";
	}
	
	@RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
	public String registration( @ModelAttribute Customer customer, Model model) 
	{
		String uuid=UUID.randomUUID().toString();
		
		customer.setUUID(uuid);
		
		
		try{
		customerService.save(customer);
		}catch (Exception e) {
			if(e.getMessage().equals(ValidationMessages.EMPTY_CUSTOMERNAME_FIELD)||
					e.getMessage().equals(ValidationMessages.NAME_ALREADY_EXIST)){
				model.addAttribute("customernameException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMessages.EMPTY_PHONE_FIELD) ||
					e.getMessage().equals(ValidationMessages.PHONE_ALREADY_EXIST)){
				model.addAttribute("phonenumberException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMessages.EMPTY_PASSWORD_FIELD)){
				model.addAttribute("passwordException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMessages.EMPTY_CUSTOMERSURNAME_FIELD)){
					model.addAttribute("surnameException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMessages.EMPTY_EMAIl_FIELD )||
					e.getMessage().equals(ValidationMessages.EMAIL_ALREADY_EXIST)){
				model.addAttribute("emailException", e.getMessage());
			}	
			return "views-customer-registration";
		}
		
		String theme ="thank's for registration"; 
		String massage="gl & hf http://localhost:8080/FirstShop/confirm/" + uuid;
		
		mailSenderService.sendMail(theme, massage, customer.geteMail());
		
		return "redirect:/home";
	}
	
	@RequestMapping (value="/confirm/{uuid}", method=RequestMethod.GET)
	public String confirm(@PathVariable String uuid){
		Customer customer=customerService.findByUUID(uuid);
		customer.setEnabled(true);
		customerService.update(customer);
		return "redirect:/home";
	}
	
	
	@RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.GET)
	public String deleteCustomer(@PathVariable(value="id") int idd){
		customerService.delete(idd);
		return "redirect:/registration";
	}
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image){
		System.out.println(image);
		customerService.saveImage(Integer.parseInt(principal.getName()), image);
		return "redirect:/profile";
		
	}
	
	
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(HttpServletRequest request, Principal principal, Model model) {


		Customer customer = customerService.fetchCustomerWithCommodity(Integer.parseInt(principal.getName()));

		model.addAttribute("customer", customer);

		return "views-customer-profile";
	}
	
	@RequestMapping(value="/deleteCommodityFromCustomer/{id}", method=RequestMethod.GET)
	public String deleteCommodityFromCustomer(Principal principal, @PathVariable("id") int idCommodity){
		
		
		customerService.deleteCommodityFromCustomer(Integer.parseInt(principal
				.getName()),idCommodity);
		return "redirect:/profile";
	}
	
}
		
		
		
		
		
/*	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {
		Customer customer = customerService.fetchCustomerWithCommodity(Integer.parseInt(principal.getName()));
		model.addAttribute("customer", customer);
		return "views-customer-profile";
	}
		
	
	@RequestMapping(value = "/buyCommodity/{id}", method = RequestMethod.GET)
	public String buyCommodity(Principal principal, @PathVariable String id) {
		customerService.buyCommodity(principal, id);
		return "redirect:/";
	}
	*/


		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
