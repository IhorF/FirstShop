package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Color;

public interface ColorService {
	void save(Color color) throws Exception;

	List<Color> findAll();

	Color findOne(int id);

	void delete(int id);

}
