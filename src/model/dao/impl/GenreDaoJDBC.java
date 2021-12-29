package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.GenreDao;
import model.entities.Genre;

public class GenreDaoJDBC  implements GenreDao{

	private Connection conn = null;
	
	public GenreDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Genre book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Genre book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Genre findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genre> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(
					"SELECT * FROM genre ORDER BY GenreName");
			
			rs = st.executeQuery();
			
			List<Genre> listGenre = new ArrayList<>();
			
			while(rs.next()) {
				Genre genre = new Genre();
				genre.setId(rs.getInt("GenreId"));
				genre.setName(rs.getString("GenreName"));
				listGenre.add(genre);
			}
			return listGenre;
			
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closePreparedStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
