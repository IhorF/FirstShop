package ua.com.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.library.dao.ColorDao;
import ua.com.library.entity.Color;
import ua.com.library.service.ColorService;
import ua.com.library.validator.Validator;
@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorDao colorDao;
	@Autowired
	@Qualifier("colorValidator")
	private Validator validator;
	
	@Override
	public void save(Color color) throws Exception {
		validator.validate(color);
		colorDao.save(color);
	}

	@Override
	public List<Color> findAll() {
		return colorDao.findAll();
	}

	@Override
	public Color findOne(int id) {
		return colorDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		colorDao.delete(id);
	}
/*	public List<Color> findColorWithCommodities() {
		return colorDao.findColorWithCommodity();
	}*/

/*	@Override
	public Color fetchColorWithCommodity(int id) {
		
		return colorDao.fetchColorWithCommodity(id);
	}*/
	
	
	
	
}
