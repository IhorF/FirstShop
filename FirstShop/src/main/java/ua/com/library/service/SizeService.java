package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Size;

public interface SizeService {
	void save(Size size) throws Exception;

	List<Size> findAll();

	Size findOne(int id);

	void delete(int id);
}
