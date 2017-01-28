package ua.com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Composition;

public interface CompositionDao extends JpaRepository<Composition, Integer>{
	
	Composition findByCotton(String cotton);
	Composition findByLycra(String lycra);
	Composition findByPolyamide(String polyamide);
	
@Query("select distinct c from Composition c left join fetch c.commodity")
List<Composition> findCompositionWithCommodity();

@Query("select distinct c from Composition c left join fetch c.commodity where c.id=:id")
Composition findCompositionWithCommodity(@Param("id") int id);


}
