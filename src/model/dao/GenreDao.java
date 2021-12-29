package model.dao;

import java.util.List;

import model.entities.Genre;

public interface GenreDao {
	
	void insert(Genre book);
	void update(Genre book);
	void deleteById(Integer id);
	Genre findById(Integer id);
	List<Genre> findAll();
}
