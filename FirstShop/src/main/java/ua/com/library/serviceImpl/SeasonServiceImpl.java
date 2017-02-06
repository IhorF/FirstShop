package ua.com.library.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.library.dao.CommodityDao;
import ua.com.library.dao.SeasonDao;
import ua.com.library.entity.Commodity;
import ua.com.library.entity.Season;
import ua.com.library.entity.Size;
import ua.com.library.service.SeasonService;
import ua.com.library.validator.Validator;

@Service
public class SeasonServiceImpl implements SeasonService {

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private SeasonDao seasonDao;
	@Autowired
	@Qualifier("seasonValidator")
	private Validator validator;

	@Override
	public void save(Season season) throws Exception {
		validator.validate(season);
		seasonDao.save(season);
	}

	@Override
	public List<Season> findAll() {
		return seasonDao.findAll();
	}

	@Override
	public Season findOne(int id) {
		return seasonDao.findOne(id);
	}

	@Transactional
	public void delete(int id) {
		Season season = seasonDao.findOne(id);
		for (Commodity commodity : season.getCommodity()) {
			commodity.setSeason(null);
			commodityDao.save(commodity);
		}
		seasonDao.delete(season);
	}
}
