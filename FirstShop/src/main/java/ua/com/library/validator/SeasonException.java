package ua.com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.dao.SeasonDao;
import ua.com.library.entity.Season;


@Component("seasonValidator")
public class SeasonException implements Validator {
		
	@Autowired
	private SeasonDao seasonDao;
		
	@Override
	public void validate(Object object) throws Exception {
		Season season=(Season)	object;		
		if(season.getName().isEmpty()){
			throw new ValidationException(ValidationMessages.EMPTY_SEASON_NAME_FIELD);
		}		
		if(seasonDao.findByName(season.getName())!=null){
			throw new ValidationException(ValidationMessages.SEASON_ALREADY_EXIST);
		}		
	}
}
