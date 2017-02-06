package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {

	Color findByName(String name);

}
