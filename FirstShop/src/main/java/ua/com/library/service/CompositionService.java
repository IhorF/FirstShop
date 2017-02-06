package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Composition;

public interface CompositionService {
	void save(Composition composition) throws Exception;

	List<Composition> findAll();

	Composition findOne(int id);

	void delete(int id);

	void addCommodityToComposition(Composition composition/* , int idCommodity */);

	void deleteCommodityFromComposition(String idCommodity);

	List<Composition> findCompositionWithCommodities();

}
