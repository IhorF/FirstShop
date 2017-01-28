package ua.com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.SizeDao;
import ua.com.library.entity.Size;

@Component("sizeValidator")
public class SizeException implements Validator {
	@Autowired
	private SizeDao sizeDao;
	
	
	@Override
	public void validate(Object object) throws Exception {
		Size size=(Size) object;
		
		if(size.getName().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_SIZE_NAME_FIELD);
		}
		
		if(sizeDao.findByName(size.getName())!=null){
			throw new ValidationException(ValidationMessages.SIZE_ALREADY_EXIST);
		}
		
		
			}
}
	
	
	

