package ua.com.library.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.library.dao.CommodityDao;
import ua.com.library.dao.SizeDao;
import ua.com.library.entity.Category;
import ua.com.library.entity.Commodity;
import ua.com.library.entity.Size;
import ua.com.library.service.SizeService;
import ua.com.library.validator.Validator;
@Service
public class SizeServiceImpl implements SizeService{
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private SizeDao sizeDao;
	@Autowired
	@Qualifier("sizeValidator")
	private Validator validator;
	
	
	
	@Override
	public void save(Size size) throws Exception  {
		validator.validate(size);
		sizeDao.save(size);
	}

	@Override
	public List<Size> findAll() {
		return sizeDao.findAll();
	}

	@Override
	public Size findOne(int id) {
		return sizeDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		Size size=sizeDao.findOne(id);
		
		for (Commodity commodity : size.getCommodity()) {
			commodity.setSize(null);
			commodityDao.save(commodity);
			
		}
		sizeDao.delete(size);
	}
	}


