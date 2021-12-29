package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.BookDao;
import model.entities.Book;

public class BookDaoJDBC implements BookDao{

	private Connection conn = null;
	
	public BookDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Book book) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO book (BookTitle, Author, Publisher, InternalCode, GenreId)"
					+"VALUES (?, ?, ?, ?, ?)");
			
			st.setString(1, book.getBookTitle());
			st.setString(2, book.getAuthor());
			st.setString(3, book.getPublisher());
			st.setInt(4, book.getBookInternalId());
			st.setInt(5, book.getGenreId());
			
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closePreparedStatement(st);
		}
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findById(Integer id) {
		return null;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
