package model.dao;

import java.util.List;

import model.entities.Book;

public interface BookDao {
	
	void insert(Book book);
	void update(Book book);
	void deleteById(Integer id);
	Book findById(Integer id);
	List<Book> findAll();
}
