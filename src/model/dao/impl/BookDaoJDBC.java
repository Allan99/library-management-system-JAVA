package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.BookDao;
import model.entities.Book;
import model.entities.Genre;

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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(null);
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closePreparedStatement(st);
		}
	}

	@Override
	public Book findById(Integer id) {
		Book book = new Book();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT book.*, genre.GenreName "
					+ "FROM book "
					+ "INNER JOIN genre ON genre.GenreId=book.GenreId "
					+ "WHERE book.BookId = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				book.setBookId(rs.getInt("BookId"));
				book.setBookTitle(rs.getString("BookTitle"));
				book.setAuthor(rs.getString("Author"));
				book.setPublisher(rs.getString("Publisher"));
				book.setBookInternalId(rs.getInt("InternalCode"));
				Genre genre = new Genre();
				genre.setId(rs.getInt("GenreId"));
				genre.setName(rs.getString("GenreName"));
				book.setGenre(genre);
				return book;
			}
			return null;
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closePreparedStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Book> findAll() {
		List<Book> list = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT book.*, genre.GenreName "
					+ "FROM book "
					+ "INNER JOIN genre ON genre.GenreId=book.GenreId");
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("BookId"));
				book.setBookTitle(rs.getString("BookTitle"));
				book.setAuthor(rs.getString("Author"));
				book.setPublisher(rs.getString("Publisher"));
				book.setBookInternalId(rs.getInt("InternalCode"));
				Genre genre = new Genre();
				genre.setId(rs.getInt("GenreId"));
				genre.setName(rs.getString("GenreName"));
				book.setGenre(genre);
				list.add(book);
			}
			return list;
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closePreparedStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
