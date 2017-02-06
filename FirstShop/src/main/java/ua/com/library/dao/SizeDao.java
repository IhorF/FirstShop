package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Size;

public interface SizeDao extends JpaRepository<Size, Integer> {
	
	Size findByName(String name);
}
