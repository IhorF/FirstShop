package ua.com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.CompositionDao;
import ua.com.library.entity.Composition;


@Component("compositionValidator")
public class CompositionValidator implements Validator {
	@Autowired
	CompositionDao compositionDao;
	
	
	@Override
	public void validate(Object object) throws Exception {
		Composition composition=(Composition) object;
		if(composition.getLycra().isEmpty() || composition.getPolyamide().isEmpty() || composition.getCotton().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_FIELD);
		}
		if((Integer.parseInt(composition.getLycra())+Integer.parseInt(composition.getCotton())+Integer.parseInt(composition.getPolyamide()))!=100){
			throw new ValidationException(ValidationMessages.COMPOSITION_VALUE_TOO_LARGE_OR_TOO_SMALL);
		}
		if(compositionDao.findByCotton(composition.getCotton())!=null
				&& compositionDao.findByPolyamide(composition.getPolyamide())!=null
				&& compositionDao.findByLycra(composition.getLycra())!=null){
			throw new ValidationException(ValidationMessages.COMPOSITION_ALREADY_EXIST);
		}
	}
}
