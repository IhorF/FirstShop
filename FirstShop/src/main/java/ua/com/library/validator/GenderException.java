package ua.com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.GenderDao;
import ua.com.library.entity.Gender;

@Component("genderValidator")
public class GenderException implements Validator {
	
	@Autowired
	private GenderDao genderDao;
	
	
	@Override
	public void validate(Object object) throws Exception {
		Gender gender=(Gender) object;
		
		
		if(gender.getName().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_GENDER_NAME_FIELD);
		}
		
		if(genderDao.findByName(gender.getName())!=null){
			throw new ValidationException(ValidationMessages.GENDER_ALREADY_EXIST);
		}
		
	}

}
