package ua.com.library.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.library.dao.CommodityDao;
import ua.com.library.dao.GenderDao;
import ua.com.library.entity.Commodity;
import ua.com.library.entity.Gender;
import ua.com.library.service.GenderService;
import ua.com.library.validator.Validator;

@Service
public class GenderServiceImpl implements GenderService {

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private GenderDao genderDao;
	@Autowired
	@Qualifier("genderValidator")
	private Validator validator;

	@Override
	public void save(Gender gender) throws Exception {
		validator.validate(gender);
		genderDao.save(gender);
	}

	@Override
	public List<Gender> findAll() {
		return genderDao.findAll();
	}

	@Override
	public Gender findOne(int id) {
		return genderDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		Gender gender = genderDao.findOne(id);
		for (Commodity commodity : gender.getCommodity()) {
			commodity.setGender(null);
			commodityDao.save(commodity);
		}
		genderDao.delete(gender);
	}
}
