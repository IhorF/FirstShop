package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Gender;

public interface GenderDao extends JpaRepository<Gender, Integer> {
	
	Gender findByName(String name);
}
