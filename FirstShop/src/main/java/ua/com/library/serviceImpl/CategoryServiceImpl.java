package ua.com.library.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.library.dao.CategoryDao;
import ua.com.library.dao.CommodityDao;
import ua.com.library.entity.Category;
import ua.com.library.entity.Commodity;
import ua.com.library.entity.Composition;
import ua.com.library.service.CategoryService;
import ua.com.library.validator.Validator;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	@Qualifier("categoryValidator")
	private Validator validator;

	@Override
	public void save(Category category) throws Exception {
		validator.validate(category);
		categoryDao.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		Category category = categoryDao.findOne(id);
		for (Commodity commodity : category.getCommodity()) {
			commodity.setCategory(null);
			commodityDao.save(commodity);
		}
		categoryDao.delete(category);
	}

}
