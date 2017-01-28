package ua.com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.CategoryDao;
import ua.com.library.entity.Category;


@Component("categoryValidator")
public class CategoryException implements Validator{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void validate(Object object) throws Exception {
		Category category=(Category) object;
		
		if(category.getName().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_CATEGORY_NAME_FIELD);
		}
		
		if(categoryDao.findByName(category.getName())!=null){
			throw new ValidationException(ValidationMessages.CATEGORY_ALREADY_EXIST);
		}
		
	}

}
