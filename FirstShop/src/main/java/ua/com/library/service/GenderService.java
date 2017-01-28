package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Gender;

public interface GenderService {
	void save(Gender gender) throws Exception;

	List<Gender> findAll();

	Gender findOne(int id);

	void delete(int id);
}
