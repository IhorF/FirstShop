package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	
	Customer findByName(String name);
	Customer findByPhoneNumber(String phoneNumber);
	
	@Query("SELECT DISTINCT c FROM Customer c LEFT JOIN FETCH c.commodities WHERE c.id =:id")
	Customer fetchCustomerWithCommodity(@Param("id") int id);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.name =:name")
	boolean customerExistsByName(@Param("name") String name);

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.eMail =:email")
	boolean customerExistsByEmail(@Param("email") String email);
	
	
	@Query("SELECT c FROM Customer c where c.UUID =:uuid")
	Customer findByUUID(@Param ("uuid") String uuid);
}
