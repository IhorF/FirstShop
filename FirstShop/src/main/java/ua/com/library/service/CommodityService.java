package ua.com.library.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.library.entity.Commodity;

public interface CommodityService {

	void save(Commodity commodity) throws Exception;

	List<Commodity> findAll();

	Commodity findOne(int id);

	void delete(int id);

	public void saveImage(int id, MultipartFile multipartFile);

	public void updateCommodity(Commodity commodity);

}
