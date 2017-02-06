package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Category;

public interface CategoryService {
	void save(Category category) throws Exception;

	List<Category> findAll();

	Category findOne(int id);

	void delete(int id);

}
