package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Season;

public interface SeasonService {
	void save(Season season) throws Exception;

	List<Season> findAll();

	Season findOne(int id);

	void delete(int id);
}
