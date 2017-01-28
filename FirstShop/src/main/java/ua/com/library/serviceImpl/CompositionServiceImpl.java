package ua.com.library.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.library.dao.CommodityDao;
import ua.com.library.dao.CompositionDao;
import ua.com.library.entity.Commodity;
import ua.com.library.entity.Composition;
import ua.com.library.service.CompositionService;
import ua.com.library.validator.Validator;

@Service
public class CompositionServiceImpl implements CompositionService {

	@Autowired
	private CompositionDao compositionDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("compositionValidator")
	private Validator validator;
	
	
	
	public void save(Composition composition) throws Exception{
		validator.validate(composition);
		compositionDao.save(composition);
	}

	public List<Composition> findAll() {
		return compositionDao.findAll();
	}

	public Composition findOne(int id) {
		return compositionDao.findOne(id);
	}
	@Transactional
	public void delete(int id) {
//		compositionDao.delete(id);
		
		Composition composition=compositionDao.findOne(id);
		
		for (Commodity commodity : composition.getCommodity()) {
			commodity.setComposition(null);
			commodityDao.save(commodity);
			
		}
		compositionDao.delete(composition);
		
	}

	
	@Transactional
	public void addCommodityToComposition(Composition composition/*, int idCommodity*/) {
		
		compositionDao.saveAndFlush(composition);
	/*	Commodity commodity=commodityDao.findOne(idCommodity);
		
		commodity.setComposition(composition);
		commodityDao.save(commodity);*/
		
		
	}
	@Transactional
	public void deleteCommodityFromComposition(String idCommodity) {
		
		Commodity commodity=commodityDao.findOne(Integer.parseInt(idCommodity));
		
		commodity.setComposition(null);
		
		commodityDao.save(commodity);
		
		
	}
	
	public List<Composition> findCompositionWithCommodities() {
		return compositionDao.findCompositionWithCommodity();
	}


	

}
