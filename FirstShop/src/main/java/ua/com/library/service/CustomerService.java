package ua.com.library.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import ua.com.library.dto.CommodityDTO;
import ua.com.library.entity.Customer;

public interface CustomerService {
	void save(Customer customer)throws Exception;

	List<Customer> findAll();

	Customer findOne(int id);

	void delete(int id);
	
	void buyCommodity(Principal principal, String id);
	
	Customer fetchCustomerWithCommodity(int id);
	void deleteCommodityFromCustomer(int idCustomer, int idCommodity);
	public void saveImage( int id, MultipartFile multipartFile);
	
	Customer findByUUID(String uuid);
	void update(Customer customer);

	
  // for cookie
 
    public Cookie intoBasket(int id, int quantity, HttpServletRequest request, HttpServletResponse response);
    
    List<CommodityDTO> customerCommoditiesCookie(HttpServletRequest request);
    
    public void getOrder(String idCustomer, String idCommodity, HttpServletRequest request, HttpServletResponse response);
    
    public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);
	
	
	
	
	
	
	

}
