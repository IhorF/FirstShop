package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Commodity;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {

	Commodity findByPrice(double price);

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Commodity c WHERE c.articul =:articul")
	boolean commodityExistsByArticul(@Param("articul") String articul);
}
