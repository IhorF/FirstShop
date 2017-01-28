package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	Category findByName(String name);

}
