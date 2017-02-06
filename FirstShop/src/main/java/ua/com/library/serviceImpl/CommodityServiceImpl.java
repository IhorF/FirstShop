package ua.com.library.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.library.dao.CommodityDao;
import ua.com.library.entity.Commodity;
import ua.com.library.service.CommodityService;
import ua.com.library.validator.Validator;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("commodityValidator")
	private Validator validator;

	public void save(Commodity commodity) throws Exception {
		validator.validate(commodity);
		commodityDao.save(commodity);
	}

	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	public Commodity findOne(int id) {
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
		commodityDao.delete(id);
	}

	@Transactional
	public void saveImage(int id, MultipartFile multipartFile) {
		Commodity commodity = commodityDao.findOne(id);
		System.out.println(commodity.getArticul());
		String path = System.getProperty("catalina.home") + "/resources/"
				+ commodity.getArticul() + "/"
				+ multipartFile.getOriginalFilename();
		
		commodity.setPathImage("resources/" + commodity.getArticul() + "/"
				+ multipartFile.getOriginalFilename());
		
		File file = new File(path);
		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(new File(System.getProperty("catalina.home")
						+ "/resources/"
						+ commodity.getArticul() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
		commodityDao.save(commodity);
	}

	@Override
	public void updateCommodity(Commodity commodity) {
		commodityDao.save(commodity);
	}
}
