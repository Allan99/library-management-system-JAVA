package model.dao;

import db.DB;
import model.dao.impl.BookDaoJDBC;
import model.dao.impl.GenreDaoJDBC;

public class DaoFactory {
	
	public static BookDaoJDBC createBookDao() {
		return new BookDaoJDBC(DB.getConnection());
	}
	
	public static GenreDaoJDBC createGenreDao() {
		return new GenreDaoJDBC(DB.getConnection());
	}
}
