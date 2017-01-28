package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {
	
	
	
	Color findByName(String name);
	
	
	
	
	
	
	
	
	
	
	/*@Query("select distinct c from Color c left join fetch c.commodity")
	List<Color> findColorWithCommodity();

	@Query("select distinct c from Color c left join fetch c.color where c.id=:id")
	Color findColorWithCommodity(@Param("id") int id);*/
	
	/*
	@Query("SELECT DISTINCT c FROM Color c LEFT JOIN FETCH c.commodity WHERE c.id =:id")
	Color fetchColorWithCommodity(@Param("id") int id);*/

}
