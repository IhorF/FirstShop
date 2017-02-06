package ua.com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Season;

public interface SeasonDao extends JpaRepository<Season, Integer> {

	Season findByName(String name);
}
