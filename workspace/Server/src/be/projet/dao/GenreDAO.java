package be.projet.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import be.projet.pojo.Genre;

public class GenreDAO extends DAO<Genre> {
	public GenreDAO(Connection conn)
	{
		super(conn);
	}
	
	@Override
	public boolean create(Genre g)	
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Genre g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Genre g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Genre> getAll() {
		
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String query = "SELECT id_util, libel_genre FROM genre";
    	List<Genre> listeGenre = new ArrayList<>();       
        try {
            statement = connect.prepareStatement(query);
            resultado = statement.executeQuery();
            
            
            while (resultado.next()) {
				String lbl = resultado.getString(1);
				int id = resultado.getInt(2);
				
				listeGenre.add(new Genre(lbl, id));

        }
        }
        catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if( resultado!= null) {
				try {
					resultado.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listeGenre;
	}

	@Override
	public Genre find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genre> find(String l) {
		// TODO Auto-generated method stub
		return null;
	}
}