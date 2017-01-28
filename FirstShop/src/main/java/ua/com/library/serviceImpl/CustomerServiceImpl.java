package ua.com.library.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.library.dao.CommodityDao;
import ua.com.library.dao.CustomerDao;
import ua.com.library.dto.CommodityDTO;
import ua.com.library.entity.Commodity;
import ua.com.library.entity.Customer;
import ua.com.library.entity.Role;
import ua.com.library.service.CustomerService;
import ua.com.library.validator.Validator;

@Service("userDetailsService")
public class CustomerServiceImpl implements CustomerService, UserDetailsService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(Customer customer) throws Exception {
		validator.validate(customer);
		customer.setRole(Role.ROLE_USER);
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerDao.save(customer);

	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public Customer findOne(int id) {
		return customerDao.findOne(id);
	}

	public void delete(int id) {
		customerDao.delete(id);

	}

	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {

		return customerDao.findByName(name);
	}

	public Customer fetchCustomerWithCommodity(int id) {
		return customerDao.fetchCustomerWithCommodity(id);
	}

	@Transactional
	public void deleteCommodityFromCustomer(int idCustomer, int idCommodity) {

		Customer customer = customerDao.findOne(idCustomer);

		customer.getCommodities().remove(commodityDao.findOne(idCommodity));

	}

	@Transactional
	public void buyCommodity(Principal principal, String id) {
		Customer customer = customerDao.findOne(Integer.parseInt(principal
				.getName()));
	
		Commodity commodity = commodityDao.findOne(Integer.parseInt(id));

		customer.getCommodities().add(commodity);
	}

	@Transactional
	public void saveImage(int id, MultipartFile multipartFile) {

		Customer customer = customerDao.findOne(id);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ customer.getName() + "/"
				+ multipartFile.getOriginalFilename();

		customer.setPathImage("resources/" + customer.getName() + "/"
				+ multipartFile.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(new File(System
						.getProperty("catalina.home")
						+ "/resources/"
						+ customer.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
		customerDao.save(customer);
	}

	@Override
	public Customer findByUUID(String uuid) {
		return customerDao.findByUUID(uuid);
	}

	@Override
	public void update(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public Cookie intoBasket(int id, int quantity, HttpServletRequest request,
			HttpServletResponse response) {
		
		
		request.getSession(false);
		Commodity commodity= commodityDao.findOne(id);
		double purshasePrice= commodity.getPrice()*quantity;
		System.out.println(purshasePrice);
		String price=commodity.getArticul()+purshasePrice;
		
		Cookie commodityCookie = new Cookie(price, String.valueOf(commodity.getId()));
		commodityCookie.setMaxAge(24 * 60 * 60 * 60);
		commodityCookie.setHttpOnly(true);
		commodityCookie.setPath("/");
	
		response.addCookie(commodityCookie);
		return commodityCookie;
		
	}

	@Override
	public List<CommodityDTO> customerCommoditiesCookie(HttpServletRequest request) {
		request.getSession(false);
		List<CommodityDTO> commodities = new ArrayList<>();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {
				
			} else {
				CommodityDTO com=new CommodityDTO();
				Commodity comPath=commodityDao.findOne(Integer.parseInt(cookie.getValue()));
				com.setId(Integer.parseInt(cookie.getValue()));
				com.setArticul(cookie.getName().substring(0,3));
				com.setPrice(Double.parseDouble(cookie.getName().substring(3)));
				System.out.println(comPath.getPathImage());
				com.setPathImage(comPath.getPathImage());
				commodities.add(com);
			}
		}
		return commodities;
	}
	

	@Override
	@Transactional
	public void getOrder(String idCustomer, String idCommodity,
			HttpServletRequest request, HttpServletResponse response) {
		Customer customer= customerDao.fetchCustomerWithCommodity(Integer.parseInt(idCustomer));
		Commodity commodity= commodityDao.findOne(Integer.parseInt(idCommodity));
		customer.getCommodities().add(commodity);

		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, idCommodity, response);
	}

	@Override
	public void deleteCookieFromOrder(String id, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);
		
	}

	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            if (id.equals(cookies[i].getValue())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setPath("/");
                cookie.setValue(null);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
