package ua.com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.CustomerDao;
import ua.com.library.entity.Customer;


@Component("customerValidator")
public class CustomerValidator implements Validator{

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	public void validate(Object object) throws Exception {
		Customer customer=(Customer) object;	
		if(customer.getName().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_CUSTOMERNAME_FIELD);
		}
		if(customer.getSurName().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_CUSTOMERSURNAME_FIELD);
		}
		if(customerDao.findByName(customer.getName()) != null){
			throw new ValidationException(ValidationMessages.NAME_ALREADY_EXIST);
		}
		if(customer.getPhoneNumber().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_PHONE_FIELD);
		}
		if(customerDao.findByPhoneNumber(customer.getPhoneNumber()) != null){
			throw new ValidationException(ValidationMessages.PHONE_ALREADY_EXIST);
		}
		if(customerDao.customerExistsByEmail(customer.geteMail())){
			throw new ValidationException(ValidationMessages.EMAIL_ALREADY_EXIST);
		}
		if(customer.geteMail().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_EMAIl_FIELD);
		}
		if(customer.getPassword().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_PASSWORD_FIELD);
		}	
	}
}
