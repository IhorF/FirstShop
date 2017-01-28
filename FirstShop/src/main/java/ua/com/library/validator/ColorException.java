package ua.com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.ColorDao;
import ua.com.library.entity.Color;

@Component("colorValidator")
public class ColorException implements Validator {

	@Autowired
	private ColorDao colorDao;
	
	
	@Override
	public void validate(Object object) throws Exception {
		Color color=(Color) object;
		
		if(color.getName().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_COLOR_NAME_FIELD);
		}
		
		if(colorDao.findByName(color.getName())!=null){
			throw new ValidationException(ValidationMessages.COLOR_ALREADY_EXIST);
		}
		
		
			}
	
	
	

}
